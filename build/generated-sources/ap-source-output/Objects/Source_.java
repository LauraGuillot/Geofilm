package Objects;

import Objects.Picture;
import Objects.Sequence;
import Objects.Sound;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-30T16:06:08")
@StaticMetamodel(Source.class)
public class Source_ { 

    public static volatile SingularAttribute<Source, Integer> sourceId;
    public static volatile CollectionAttribute<Source, Sound> soundCollection;
    public static volatile CollectionAttribute<Source, Picture> pictureCollection;
    public static volatile SingularAttribute<Source, String> sourceType;
    public static volatile CollectionAttribute<Source, Sequence> sequenceCollection;
    public static volatile SingularAttribute<Source, String> sourceTitle;

}