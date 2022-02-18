import java.awt.Color;
import java.awt.Shape;
import java.util.LinkedList;

import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.ShapeUtilities;


public class GraficaFDIS extends JFrame {

	private static final long serialVersionUID = 1L;
	private LinkedList<Punto2D> puntitos1;
	private LinkedList<Punto2D> puntitos2;
	
    public GraficaFDIS(LinkedList<Punto2D> puntitos1, LinkedList<Punto2D> puntitos2) {

        super("Función de Distribución");
        this.puntitos1 = puntitos1;
        this.puntitos2 = puntitos2;
        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 400));
        setContentPane(chartPanel);

    }
    
    private XYDataset createDataset() {
        
        final XYSeries series1 = new XYSeries("F empírica");
        final XYSeries series2 = new XYSeries("F teórica");
        
        Punto2D temp1;
        Punto2D temp2;
        for(int i=0;i<this.puntitos1.size(); i++){
        	temp1 = this.puntitos1.get(i);
        	temp2 = this.puntitos2.get(i);
        	
        	series1.add(temp1.getX(), temp1.getY());
        	series2.add(temp2.getX(), temp2.getY());
        }
        
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
                
        return dataset;
        
    }

    private JFreeChart createChart(final XYDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "",      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
  //      legend.setDisplaySeriesShapes(true);
        
        final XYPlot plot = chart.getXYPlot();
        ValueAxis range = plot.getRangeAxis();
        range.setVisible(false);
        
        
        plot.setBackgroundPaint(Color.white);
    //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesLinesVisible(1, true);
        Shape cross = ShapeUtilities.createDiagonalCross(0.3f, 0.3f);
        renderer.setSeriesShape(1,cross);
        renderer.setSeriesShape(0,cross);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        return chart;
        
    }
}
