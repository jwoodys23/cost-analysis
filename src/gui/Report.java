package gui;

import javafx.scene.chart.BarChart;
import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.datatype.BigDecimalType;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

import java.awt.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;

/**
 * Created by jourdanwoodrich on 7/9/16.
 */
public class Report {

    private Connection con;

    public Report() {
        System.out.println(con);
        if (con != null) return;
        try {
            String url = "jdbc:mysql://localhost:3306/swingtest?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "password");
            //createTable();
            build();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        System.out.println("Connecting to db and making report");
    }

    private void build() {
        CurrencyType currencyType = new CurrencyType();


        StyleBuilder boldStyle         = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle  = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);
        StyleBuilder titleStyle        = stl.style(boldCenteredStyle)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setFontSize(15);



        TextColumnBuilder<String> partName = col.column("Part Name", "part_name", type.stringType());
        TextColumnBuilder<String> partNumber = col.column("Part Number", "part_number", type.stringType());
        TextColumnBuilder<String> constantColumn = col.column("Variance", "constant", type.stringType());
        TextColumnBuilder<BigDecimal> actMaterialColumn = col.column("Actual Material Costs","material_cost", currencyType);
        TextColumnBuilder<BigDecimal> stdmaterialColumn = col.column("Standard Material Costs", "stdMaterialCost", type.bigDecimalType());
        TextColumnBuilder<BigDecimal> materialVarianceColumn = actMaterialColumn.subtract(stdmaterialColumn).setTitle("Material Variance");
        TextColumnBuilder<BigDecimal> actLaborColumn = col.column("Actual Labor Costs", "labor_cost", type.bigDecimalType());
        TextColumnBuilder<BigDecimal> stdLaborColumn = col.column("Standard Labor Costs", "stdLaborCost", type.bigDecimalType());
        TextColumnBuilder<BigDecimal> laborVarianceColumn = actLaborColumn.subtract(stdLaborColumn).setTitle("Material Variance");
        TextColumnBuilder<BigDecimal> freightCost = col.column("Freight Cost", "freight_cost", type.bigDecimalType());
        TextColumnBuilder<BigDecimal> totalActualColumn = col.column("Total Actual Costs", "totalActual", type.bigDecimalType());
        TextColumnBuilder<BigDecimal> totalStandardColumn = col.column("Total Standard Costs", "totalStandard", type.bigDecimalType());

        Bar3DChartBuilder materialChart = cht.bar3DChart()
                                            .setTitle("Actual Material Costs to Standard")
                                            .setCategory(constantColumn)
                                            .addSerie(
                                                    cht.serie(actMaterialColumn), cht.serie(stdmaterialColumn));
        Bar3DChartBuilder laborChart = cht.bar3DChart()
                                            .setTitle("Actual Labor Costs to Standard")
                                            .setCategory(constantColumn)
                                            .addSerie(
                                                    cht.serie(actLaborColumn), cht.serie(stdLaborColumn));

        Bar3DChartBuilder totalVarianceChart = cht.bar3DChart()
                .setTitle("Total Variance of Unit")
                .setCategory(constantColumn)
                .addSerie(
                        cht.serie(totalActualColumn), cht.serie(totalStandardColumn)
                );





        try {
            report()
                    .setColumnTitleStyle(columnTitleStyle)
                    .highlightDetailEvenRows()
                    .setSubtotalStyle(boldStyle)
                    .title(cmp.text("Variance Report").setStyle(titleStyle))
                    .columns(partName, partNumber, actMaterialColumn, stdmaterialColumn, actLaborColumn, stdLaborColumn, freightCost, totalStandardColumn, totalActualColumn)

                    .subtotalsAtSummary(sbt.sum(actMaterialColumn), sbt.sum(stdmaterialColumn), sbt.sum(actLaborColumn), sbt.sum(stdLaborColumn), sbt.sum(freightCost), sbt.sum(totalStandardColumn), sbt.sum(totalActualColumn))
                    .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle))
                    .summary(cmp.horizontalList(materialChart, laborChart, totalVarianceChart))

                    .setDataSource("select * from parts", con)
                    .show(false);
        } catch (DRException e){
            e.printStackTrace();
        }

    }
    private class CurrencyType extends BigDecimalType {
        private static final long serialVersionUID = 1L;
        @Override
        public String getPattern() {
            return "$ #,###.00";
        }
    }

}
