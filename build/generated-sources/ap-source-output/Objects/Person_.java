package Objects;

import Objects.Badlocation;
import Objects.Connect;
import Objects.Favorite;
import Objects.Liked;
import Objects.Multimedia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-08T19:42:33")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> personName;
    public static volatile CollectionAttribute<Person, Liked> likedCollection;
    public static volatile CollectionAttribute<Person, Favorite> favoriteCollection;
    public static volatile CollectionAttribute<Person, Badlocation> badlocationCollection;
    public static volatile SingularAttribute<Person, String> personPassword;
    public static volatile SingularAttribute<Person, String> personEmail;
    public static volatile CollectionAttribute<Person, Connect> connectCollection;
    public static volatile SingularAttribute<Person, Integer> personId;
    public static volatile CollectionAttribute<Person, Multimedia> multimediaCollection2;
    public static volatile CollectionAttribute<Person, Multimedia> multimediaCollection1;
    public static volatile SingularAttribute<Person, String> personFirstname;
    public static volatile CollectionAttribute<Person, Multimedia> multimediaCollection;

}