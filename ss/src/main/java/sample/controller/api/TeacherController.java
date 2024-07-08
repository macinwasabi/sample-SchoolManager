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
import sample.dto.TeacherDto;
import sample.service.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  /**
   * 一覧取得API
   *
   * @return 取得結果のリスト
   */
  @GetMapping
  public List<TeacherDto> getAll() {
    return teacherService.selectAll();
  }

  /**
   * 取得API
   *
   * @param teacherId 取得したい生徒の先生番号
   * @return 取得結果のDTO
   */
  @GetMapping("/{teacherId}")
  public TeacherDto get(@PathVariable("teacherId") Long teacherId) {
    // PathParamは設定次第で、変数名とパラメーター名が同じであればvalueを省略できる
    TeacherDto response = teacherService.select(teacherId);
    return response;
  }

  /**
   * 作成API
   *
   * @param teacher 登録したい先生情報
   * @return 登録した先生情報
   */
  @PostMapping
  public TeacherDto post(@RequestBody TeacherDto teacher) {
    teacherService.insert(teacher);
    return teacherService.select(teacher.getTeacherId());
  }

  /**
   * 更新API
   *
   * @param teacherId 更新したい先生番号
   * @param teacher   更新したい先生情報
   */
  @PutMapping("/{studentId}")
  public void put(@PathVariable("studentId") Long teacherId, @RequestBody TeacherDto teacher) {
    // パスパラメーターの先生番号をDTOへセット
    teacher.setTeacherId(teacherId);
    teacherService.update(teacher);
  }

  /**
   * 削除API
   *
   * @param teacherId 削除したい先生情報の先生番号
   */
  @DeleteMapping("/{teacherId}")
  public void delete(@PathVariable("teacherId") Long teacherId) {
    teacherService.delete(teacherId);
  }
}
