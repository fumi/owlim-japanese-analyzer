package jp.linkeddata.owlim;

import com.ontotext.trree.plugin.lucene.AnalyzerFactory;
import net.moraleboost.lucene.analysis.ja.SenAnalyzer;
import org.apache.lucene.analysis.Analyzer;

public class SenAnalyzerFactory implements AnalyzerFactory {
    public static final String SEN_CONFIG_FILE = System.getProperty("jp.linkeddata.sen.configfile");
    public Analyzer createAnalyzer(){
        String[] filters = new String[] { "^助詞,.*$" };
        return new SenAnalyzer(SEN_CONFIG_FILE, filters);
    }
}
