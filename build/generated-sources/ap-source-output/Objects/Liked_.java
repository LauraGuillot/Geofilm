package Objects;

import Objects.LikedPK;
import Objects.Multimedia;
import Objects.Person;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-07T09:56:12")
@StaticMetamodel(Liked.class)
public class Liked_ { 

    public static volatile SingularAttribute<Liked, String> likedType;
    public static volatile SingularAttribute<Liked, Multimedia> multimedia;
    public static volatile SingularAttribute<Liked, Person> person;
    public static volatile SingularAttribute<Liked, LikedPK> likedPK;

}