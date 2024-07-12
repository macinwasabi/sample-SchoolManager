package sample.logic.designpattern.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import sample.dto.StudentDto;

/**
 * クラスDTOのイテレーター。
 */
public class ClassIterator implements Iterator<StudentDto> {

  /**
   * クラス情報。
   */
  private IterableClassDto classDto;

  /**
   * インデックス。
   */
  private int index;

  public ClassIterator(IterableClassDto classDto) {
    this.classDto = classDto;
  }

  @Override
  public boolean hasNext() {
    if (index < classDto.length()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public StudentDto next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    StudentDto student = classDto.get(index);
    index++;
    return student;
  }
}
