package jp.linkeddata.owlim;

import com.ontotext.trree.plugin.lucene.AnalyzerFactory;
import org.aminds.lucene.analysis.NormalizedJapaneseAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.Version;

public class NormalizedJapaneseAnalyzerFactory implements AnalyzerFactory {
    public Analyzer createAnalyzer(){
        return new NormalizedJapaneseAnalyzer(Version.LUCENE_35);
    }
}
