package jp.linkeddata.owlim;

import com.ontotext.trree.plugin.lucene.AnalyzerFactory;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.Version;
import jp.linkeddata.lucene.analysis.CJKSingleWordAnalyzer;

public class CJKSingleWordAnalyzerFactory implements AnalyzerFactory {
    public Analyzer createAnalyzer(){
        return new CJKSingleWordAnalyzer(Version.LUCENE_35);
    }
}
