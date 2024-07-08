package sample.controller.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.dto.StudentDto;
import sample.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  @Autowired
  StudentService studentService;

  /**
   * 一覧取得API
   *
   * @return 取得結果のリスト
   */
  @GetMapping
  public List<StudentDto> getAll() {
    return studentService.selectAll();
  }

  /**
   * 取得API
   *
   * @param studentId 取得したい生徒の生徒番号
   * @return 取得結果のDTO
   */
  @GetMapping("/{studentId}")
  public StudentDto get(@PathVariable("studentId") Long studentId) {
    // PathParamは設定次第で、変数名とパラメーター名が同じであればvalueを省略できる
    StudentDto response = studentService.select(studentId);
    return response;
  }

  /**
   * 作成API
   *
   * @param student 登録したい生徒情報
   * @return 登録した生徒情報
   */
  @PostMapping
  public StudentDto post(@RequestBody StudentDto student) {
    studentService.insert(student);
    return studentService.select(student.getStudentId());
  }

  /**
   * 更新API
   *
   * @param studentId 更新したい生徒番号
   * @param student   更新したい生徒情報
   */
  @PutMapping("/{studentId}")
  public void put(@PathVariable("studentId") Long studentId, @RequestBody StudentDto student) {
    // パスパラメーターの生徒番号をDTOへセット
    student.setStudentId(studentId);
    studentService.update(student);
  }

  /**
   * 削除API
   *
   * @param studentId 削除したい生徒情報の生徒番号
   */
  @DeleteMapping("/{studentId}")
  public void delete(@PathVariable("studentId") Long studentId) {
    studentService.delete(studentId);
  }
}
