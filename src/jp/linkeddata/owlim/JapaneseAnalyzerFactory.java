package jp.linkeddata.owlim;

import com.ontotext.trree.plugin.lucene.AnalyzerFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.ja.JapaneseAnalyzer;
import org.apache.lucene.util.Version;

public class JapaneseAnalyzerFactory implements AnalyzerFactory {
    public Analyzer createAnalyzer(){
        return new JapaneseAnalyzer(Version.LUCENE_35);
    }
}
