package Objects;

import Objects.Liked;
import Objects.Location;
import Objects.Person;
import Objects.Source;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-06T09:51:20")
@StaticMetamodel(Multimedia.class)
public class Multimedia_ { 

    public static volatile SingularAttribute<Multimedia, Source> sourceId;
    public static volatile SingularAttribute<Multimedia, String> multimediaFormat;
    public static volatile SingularAttribute<Multimedia, String> multimediaPath;
    public static volatile CollectionAttribute<Multimedia, Person> personCollection;
    public static volatile SingularAttribute<Multimedia, String> multimediaDescription;
    public static volatile SingularAttribute<Multimedia, String> multimediaTitle;
    public static volatile SingularAttribute<Multimedia, String> multimediaType;
    public static volatile SingularAttribute<Multimedia, Integer> multimediaId;
    public static volatile CollectionAttribute<Multimedia, Liked> likedCollection;
    public static volatile SingularAttribute<Multimedia, String> multimediaUploadDate;
    public static volatile SingularAttribute<Multimedia, Location> locationId;
    public static volatile SingularAttribute<Multimedia, Person> publisher;
    public static volatile CollectionAttribute<Multimedia, Person> personCollection1;
    public static volatile SingularAttribute<Multimedia, String> multimediaLanguage;

}