package jp.linkeddata.owlim;

import com.ontotext.trree.plugin.lucene.AnalyzerFactory;
import net.moraleboost.lucene.analysis.ja.StandardMeCabAnalyzer;
import org.apache.lucene.analysis.Analyzer;

public class StandardMeCabAnalyzerFactory implements AnalyzerFactory {
    public static final String DIC_ENCODING = System.getProperty("net.moraleboost.mecab.encoding");
    public Analyzer createAnalyzer(){
        String[] filters = new String[] { "^助詞,.*$" };
        return new StandardMeCabAnalyzer(DIC_ENCODING, "", filters);
    }
}
