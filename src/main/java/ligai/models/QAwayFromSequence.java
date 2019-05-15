package ligai.models;

import ligai.enums.QuestionType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "q_away_from_sequence")
public class QAwayFromSequence extends Question {

    @Column(nullable = true)
    private String mainSequence;


    @Builder(builderMethodName = "qAwayFromSequenceBuilder")
    public QAwayFromSequence(Long id,
                             String task,
                             String answerString,
                             QuestionType questionType,
                             Lesson lesson,
                             String mainSequence) {
        super(id, task, answerString, questionType, lesson);
        this.mainSequence = mainSequence;

    }

}
