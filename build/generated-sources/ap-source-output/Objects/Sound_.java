package Objects;

import Objects.Multimedia;
import Objects.Source;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-30T16:41:52")
@StaticMetamodel(Sound.class)
public class Sound_ { 

    public static volatile SingularAttribute<Sound, Integer> soundId;
    public static volatile SingularAttribute<Sound, Source> sourceId;
    public static volatile SingularAttribute<Sound, Multimedia> multimediaId;

}