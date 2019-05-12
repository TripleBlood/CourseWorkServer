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
@Table(name = "q_groups")
public class QGroups extends Question{

    String a_group_name;
    String b_group_name;

    String variant1;
    String variant2;
    String variant3;
    String variant4;

    @Builder(builderMethodName = "qGroupsBuilder")
    public QGroups(
            Long id,
            String task,
            String answerString,
            QuestionType questionType,
            Lesson lesson,
            String variant1,
            String variant2,
            String variant3,
            String variant4,
            String a_group_name,
            String b_group_name) {
        super(id, task, answerString, questionType, lesson);

        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.variant4 = variant4;

        this.a_group_name = a_group_name;
        this.b_group_name = b_group_name;
    }
}
