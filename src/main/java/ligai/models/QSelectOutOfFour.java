package ligai.models;


import ligai.enums.QuestionType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "q_select_out_of_four")
public class QSelectOutOfFour extends Question {

    private String variant1;
    private String variant2;
    private String variant3;
    private String variant4;

    @Builder(builderMethodName = "qSelectOutOfFourBuilder")
    public QSelectOutOfFour(Long id, String task, String answerString, QuestionType questionType,
                            Lesson lesson, String variant1, String variant2, String variant3, String variant4) {
        super(id, task, answerString, questionType, lesson);
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.variant4 = variant4;

    }

}
