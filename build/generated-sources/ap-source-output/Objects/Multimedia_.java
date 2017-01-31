package Objects;

import Objects.Location;
import Objects.Person;
import Objects.Picture;
import Objects.Sequence;
import Objects.Sound;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-30T16:41:52")
@StaticMetamodel(Multimedia.class)
public class Multimedia_ { 

    public static volatile SingularAttribute<Multimedia, Integer> multimediaIsSignaled;
    public static volatile CollectionAttribute<Multimedia, Sound> soundCollection;
    public static volatile CollectionAttribute<Multimedia, Picture> pictureCollection;
    public static volatile SingularAttribute<Multimedia, String> multimediaFormat;
    public static volatile SingularAttribute<Multimedia, Integer> multimediaDislike;
    public static volatile SingularAttribute<Multimedia, String> multimediaPath;
    public static volatile CollectionAttribute<Multimedia, Sequence> sequenceCollection;
    public static volatile CollectionAttribute<Multimedia, Person> personCollection;
    public static volatile SingularAttribute<Multimedia, String> multimediaDescription;
    public static volatile SingularAttribute<Multimedia, String> multimediaTitle;
    public static volatile SingularAttribute<Multimedia, Integer> multimediaLike;
    public static volatile SingularAttribute<Multimedia, Integer> multimediaId;
    public static volatile SingularAttribute<Multimedia, String> multimediaUploadDate;
    public static volatile SingularAttribute<Multimedia, Location> locationId;
    public static volatile SingularAttribute<Multimedia, Person> publisher;
    public static volatile SingularAttribute<Multimedia, String> multimediaLanguage;

}