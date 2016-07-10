package gui;

import model.Database;
import net.sf.dynamicreports.report.builder.chart.Bar3DChartBuilder;
import net.sf.dynamicreports.report.builder.column.PercentageColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRDataSource;


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

    //Database db = new Database();

    public Report() {
        if (con != null) return;
        try {
            String url = "jdbc:mysql://localhost:3306/swingtest?autoReconnect=true&useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "password");

            build();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        System.out.println("Connecting to db and making report");
    }

    private void build() {
        StyleBuilder boldStyle         = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle)
                .setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle  = stl.style(boldCenteredStyle)
                .setBorder(stl.pen1Point())
                .setBackgroundColor(Color.LIGHT_GRAY);

        TextColumnBuilder<String>     itemColumn      = col.column("Item",       "item",      type.stringType());
        TextColumnBuilder<Integer>    quantityColumn  = col.column("Quantity",   "quantity",  type.integerType());
        TextColumnBuilder<BigDecimal> unitPriceColumn = col.column("Unit price", "unitprice", type.bigDecimalType());
        //price = unitPrice * quantity
        TextColumnBuilder<BigDecimal> priceColumn     = unitPriceColumn.multiply(quantityColumn).setTitle("Price");
        PercentageColumnBuilder       pricePercColumn = col.percentageColumn("Price %", priceColumn);
        TextColumnBuilder<Integer>    rowNumberColumn = col.reportRowNumberColumn("No.")
        //sets the fixed width of a column, width = 2 * character width
                .setFixedColumns(2)
                .setHorizontalAlignment(HorizontalAlignment.CENTER);

        Bar3DChartBuilder itemChart = cht.bar3DChart()
                .setTitle("Sales by item")
                .setCategory(itemColumn)
                .addSerie(
                        cht.serie(unitPriceColumn), cht.serie(priceColumn));
        Bar3DChartBuilder itemChart2 = cht.bar3DChart()
                .setTitle("Sales by item")
                .setCategory(itemColumn)
                .setUseSeriesAsCategory(true)
                .addSerie(
                        cht.serie(unitPriceColumn), cht.serie(priceColumn));

        try {
            report()//create new report design
                    .setColumnTitleStyle(columnTitleStyle)
                    .highlightDetailEvenRows()
                    .columns(rowNumberColumn, itemColumn, quantityColumn, unitPriceColumn, priceColumn, pricePercColumn)
                    .groupBy(itemColumn)
                    .subtotalsAtSummary(
                            sbt.sum(unitPriceColumn), sbt.sum(priceColumn))
                    .subtotalsAtFirstGroupFooter(
                            sbt.sum(unitPriceColumn), sbt.sum(priceColumn))

                    .title(cmp.text("Getting started").setStyle(boldCenteredStyle))//shows report title
                    .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle))//shows number of page at page footer
                    .summary(cmp.horizontalList(itemChart, itemChart2))
                    .setDataSource("SELECT * FROM parts", con )//set datasource
                    .show(false);//create and show report
        } catch (DRException e) {
            e.printStackTrace();
        }
    }
    private JRDataSource createDataSource() {
        DRDataSource dataSource = new DRDataSource("item", "quantity", "unitprice");
        dataSource.add("Notebook", 1, new BigDecimal(500));
        dataSource.add("DVD", 5, new BigDecimal(30));
        dataSource.add("DVD", 1, new BigDecimal(28));
        dataSource.add("DVD", 5, new BigDecimal(32));
        dataSource.add("Book", 3, new BigDecimal(11));
        dataSource.add("Book", 1, new BigDecimal(15));
        dataSource.add("Book", 5, new BigDecimal(10));
        dataSource.add("Book", 8, new BigDecimal(9));
        return dataSource;
    }
}