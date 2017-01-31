package Objects;

import Objects.Multimedia;
import Objects.Source;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-30T16:41:52")
@StaticMetamodel(Sequence.class)
public class Sequence_ { 

    public static volatile SingularAttribute<Sequence, Source> sourceId;
    public static volatile SingularAttribute<Sequence, Multimedia> multimediaId;
    public static volatile SingularAttribute<Sequence, Integer> sequenceId;

}