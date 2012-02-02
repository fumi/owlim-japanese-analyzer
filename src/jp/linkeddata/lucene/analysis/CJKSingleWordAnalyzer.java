package jp.linkeddata.lucene.analysis;
import org.apache.lucene.analysis.StopwordAnalyzerBase;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.StopwordAnalyzerBase;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.TokenStream;

import java.io.Reader;
import java.util.Arrays;
import java.util.Set;

import jp.ac.nii.catapi.solr.analizers.CJKSingleWordCreateFilter;

/**
 *
 * CJKSingleWordAnalyzer uses CJKSingleWordCreateFilter to extend CJKAnalyzer
 * This code is almost copied from CJKAnalyzer because the class is a final class.
 *
 */
public final class CJKSingleWordAnalyzer extends StopwordAnalyzerBase {
    
  //~ Static fields/initializers ---------------------------------------------

  /**
   * An array containing some common English words that are not usually
   * useful for searching and some double-byte interpunctions.
   * @deprecated use {@link #getDefaultStopSet()} instead
   */
  @Deprecated
  public final static String[] STOP_WORDS = {
    "a", "and", "are", "as", "at", "be",
    "but", "by", "for", "if", "in",
    "into", "is", "it", "no", "not",
    "of", "on", "or", "s", "such", "t",
    "that", "the", "their", "then",
    "there", "these", "they", "this",
    "to", "was", "will", "with", "",
    "www"
  };

  //~ Instance fields --------------------------------------------------------

  /**
   * Returns an unmodifiable instance of the default stop-words set.
   * @return an unmodifiable instance of the default stop-words set.
   */
  public static Set<?> getDefaultStopSet(){
    return DefaultSetHolder.DEFAULT_STOP_SET;
  }
  
  private static class DefaultSetHolder {
    static final Set<?> DEFAULT_STOP_SET = CharArraySet
        .unmodifiableSet(new CharArraySet(Version.LUCENE_CURRENT, Arrays.asList(STOP_WORDS),
            false));
  }

  //~ Constructors -----------------------------------------------------------

  /**
   * Builds an analyzer which removes words in {@link #getDefaultStopSet()}.
   */
  public CJKSingleWordAnalyzer(Version matchVersion) {
    this(matchVersion, DefaultSetHolder.DEFAULT_STOP_SET);
  }
  
  /**
   * Builds an analyzer with the given stop words
   * 
   * @param matchVersion
   *          lucene compatibility version
   * @param stopwords
   *          a stopword set
   */
  public CJKSingleWordAnalyzer(Version matchVersion, Set<?> stopwords){
    super(matchVersion, stopwords);
  }

  /**
   * Builds an analyzer which removes words in the provided array.
   *
   * @param stopWords stop word array
   * @deprecated use {@link #CJKSingleWordAnalyzer(Version, Set)} instead
   */
  @Deprecated
  public CJKSingleWordAnalyzer(Version matchVersion, String... stopWords) {
    super(matchVersion, StopFilter.makeStopSet(matchVersion, stopWords));
  }

  //~ Methods ----------------------------------------------------------------

  @Override
  protected TokenStreamComponents createComponents(String fieldName,
      Reader reader) {
    final Tokenizer source = new CJKSingleWordTokenizer(reader);
    TokenStream stream = new StopFilter(matchVersion, source, stopwords);
    stream = new CJKSingleWordCreateFilter(stream);
    return new TokenStreamComponents(source, stream);
  }
}
