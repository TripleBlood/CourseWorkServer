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
@Table(name = "q_select_out_of_four_pic")
public class QSelectOutOfFourPic extends Question {

    private String variant1;
    private String variant2;
    private String variant3;
    private String variant4;

    // URL example: "Test course/Test theme/Test lesson/image.jpg"
    private String pictureUrl1;
    private String pictureUrl2;
    private String pictureUrl3;
    private String pictureUrl4;

    @Builder(builderMethodName = "qSelectOutOfFourPicBuilder")
    public QSelectOutOfFourPic(Long id,
                               String task,
                               String answerString,
                               QuestionType questionType,
                               Lesson lesson,
                               String variant1,
                               String variant2,
                               String variant3,
                               String variant4,
                               String pictureUrl1,
                               String pictureUrl2,
                               String pictureUrl3,
                               String pictureUrl4) {
        super(id, task, answerString, questionType, lesson);
        this.variant1 = variant1;
        this.variant2 = variant2;
        this.variant3 = variant3;
        this.variant4 = variant4;
        this.pictureUrl1 = pictureUrl1;
        this.pictureUrl2 = pictureUrl2;
        this.pictureUrl3 = pictureUrl3;
        this.pictureUrl4 = pictureUrl4;

    }
}
