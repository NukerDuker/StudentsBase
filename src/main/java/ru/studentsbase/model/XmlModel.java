package ru.studentsbase.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.studentsbase.enums.StudyProfile;
import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@NoArgsConstructor
@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlModel {

    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    List<Student> students;

    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    List<University> universities;

    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    List<Statistics> statistics;

}
