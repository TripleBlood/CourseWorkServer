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
@Table(name = "q_sequence_update")
public class QSequenceUpdate extends Question {

    @Column(nullable = true)
    private String mainSequence;

    @Column(nullable = true)
    private String suggestedBlocks;

    @Builder(builderMethodName = "qSelectOutOfFourBuilder")
    public QSequenceUpdate(Long id,
                           String task,
                           String answerString,
                           QuestionType questionType,
                           Lesson lesson,
                           String mainSequence,
                           String suggestedBlocks) {
        super(id, task, answerString, questionType, lesson);
        this.mainSequence = mainSequence;
        this.suggestedBlocks = suggestedBlocks;

    }

}
