package ladder.step2.dto;

import ladder.step2.domain.LineTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineDTOTest {
    public static final LineDTO LINE_DTO = new LineDTO(LineTest.LINE.lineInformation().getPartLines());
    
    @Test
    @DisplayName("LineDTO 생성")
    void create() {
        assertThat(LineDTOTest.LINE_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("LineDTO 데이터 있는지 확인")
    void is_exist_data() {
        assertThat(LineDTOTest.LINE_DTO.getPartLines()).isNotNull();
    }
}