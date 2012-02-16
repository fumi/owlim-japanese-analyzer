package jp.linkeddata.owlim;

import com.ontotext.trree.plugin.lucene.AnalyzerFactory;
import org.apache.lucene.analysis.Analyzer;
import jp.linkeddata.lucene.analysis.NGramAnalyzer;

public class TriGramAnalyzerFactory implements AnalyzerFactory {
    public Analyzer createAnalyzer(){
        return new NGramAnalyzer(3, 3);
    }
}
