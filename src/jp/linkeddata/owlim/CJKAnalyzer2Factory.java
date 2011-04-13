package jp.linkeddata.owlim;

import com.ontotext.trree.plugin.lucene.AnalyzerFactory;
import net.moraleboost.lucene.analysis.ja.CJKAnalyzer2;
import org.apache.lucene.analysis.Analyzer;

public class CJKAnalyzer2Factory implements AnalyzerFactory {
    public Analyzer createAnalyzer(){
        return new CJKAnalyzer2();
    }
}
