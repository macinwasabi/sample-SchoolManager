package sample.controller.api;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import sample.dto.StudentDto;
import sample.service.StudentService;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  StudentService studentService;

  private static final String URL = "/api/student";

  @Test
  @DisplayName("get 正常系")
  void get_normal() throws Exception {
    // 準備
    StudentDto dto = getStudentDto(null);
    // モック
    when(studentService.select(anyLong())).thenReturn(dto);
    // 実行
    ResultActions result = mockMvc.perform(get(URL + "/1"));
    // 期待値
    String expected = getJson(dto);
    // Assert
    result.andExpect(handler().methodName("get"));
    result.andExpect(status().is(HttpServletResponse.SC_OK));
    result.andExpect(content().json(expected));
  }

  /**
   * 生徒情報DTOを生成する。
   *
   * @param setters 個別のセッター
   * @return 生徒情報DTO
   */
  public static StudentDto getStudentDto(Consumer<StudentDto> setters) {
    StudentDto dto = new StudentDto();

    dto.setStudentId(1L);
    dto.setFamilyName("テスト");
    dto.setFirstName("太郎");

    if (setters != null) {
      // メソッド呼び出す側が個別にセットする場合に実行される
      setters.accept(dto);
    }
    return dto;
  }

  /**
   * 生徒情報DTOをJSONに変換する。
   *
   * @param dto 生徒情報DTO
   * @return JSON文字列
   * @throws JsonProcessingException
   */
  private String getJson(StudentDto dto) throws JsonProcessingException {
    // Jacksonによるオブジェクト→JSONの変換
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(dto);
    return json;
  }
}
