package kata6;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay <T>extends ApplicationFrame {
    private final Histogram <T> histogram;
    private final String nameEjeX;
    
    HistogramDisplay(Histogram<T> histogram, String nameEjeX) {
        super("Histograma");
        this.histogram = histogram;
        this.nameEjeX=nameEjeX;
        setContentPane(createPanel());
        pack();
    }
    
    private ChartPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
        chartPanel.setPreferredSize(new Dimension(500, 450));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                null, 
                nameEjeX, "NÚMERO", 
                dataset, 
                PlotOrientation.VERTICAL, 
                false, false, false);
        return chart;
    }
    
    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataset.addValue(histogram.get(key), "", (Comparable) key);
        }
        return dataset;
    }
    
    public void execute() {
        setVisible(true);
    }
}
