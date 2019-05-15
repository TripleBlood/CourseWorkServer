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
@Table(name = "q_pairs")
public class QPairs extends Question {

    private String variant1;
    private String variant2;
    private String variant3;
    private String variant4;


    // if it's picture type pair in following fields urls are contained
    private String pair1;
    private String pair2;
    private String pair3;
    private String pair4;

    @Builder(builderMethodName = "qSelectOutOfFourBuilder")
    public QPairs(Long id,
                  String task,
                  String answerString,
                  QuestionType questionType,
                  Lesson lesson,
                  String variant1,
                  String variant2,
                  String variant3,
                  String variant4) {
        super(id, task, answerString, questionType, lesson);
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.variant4 = variant4;

        this.pair1 = pair1;
        this.pair2 = pair2;
        this.pair3 = pair3;
        this.pair4 = pair4;

    }

}
