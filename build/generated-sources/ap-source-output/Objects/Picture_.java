package Objects;

import Objects.Multimedia;
import Objects.Source;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-30T16:06:08")
@StaticMetamodel(Picture.class)
public class Picture_ { 

    public static volatile SingularAttribute<Picture, Source> sourceId;
    public static volatile SingularAttribute<Picture, Multimedia> multimediaId;
    public static volatile SingularAttribute<Picture, Integer> pictureId;

}