package sample.logic.designpattern.templatemethod;

/**
 * クラス紹介文の抽象クラス。
 */
public abstract class AbstractClassIntroduciton {

  /**
   * クラス紹介文を取得する。
   *
   * @return
   */
  public String get() {
    String str = "";
    str += precontent() + "¥n";
    str += content() + "¥n";
    return str;
  }

  /**
   * クラス紹介文の前文。◯年◯組などを記述しましょう。
   */
  protected abstract String precontent();

  /**
   * クラス紹介文の本文。
   */
  protected abstract String content();
}
