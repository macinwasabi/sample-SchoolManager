package sample.logic.designpattern.templatemethod;

public class ClassIntroduction extends AbstractClassIntroduciton {

  /**
   * クラス紹介文の前文。
   */
  private String precontent = "";

  /**
   * クラス紹介文の本文。
   */
  private String content = "";

  public ClassIntroduction(String precontent, String content) {
    this.precontent = precontent;
    this.content = content;
  }

  /**
   * クラス紹介文の前文。
   */
  @Override
  protected String precontent() {
    return this.precontent;
  }

  /**
   * クラス紹介文の本文。
   */
  @Override
  protected String content() {
    return this.content;
  }
}
