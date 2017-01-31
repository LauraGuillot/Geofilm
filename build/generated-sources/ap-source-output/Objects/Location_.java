package Objects;

import Objects.Multimedia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-01-30T16:41:52")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> locationAddressComplement;
    public static volatile SingularAttribute<Location, String> locationPostalCode;
    public static volatile SingularAttribute<Location, String> locationCountry;
    public static volatile SingularAttribute<Location, Integer> locationId;
    public static volatile SingularAttribute<Location, String> locationAddress;
    public static volatile SingularAttribute<Location, String> locationCity;
    public static volatile SingularAttribute<Location, String> locationThegeom;
    public static volatile CollectionAttribute<Location, Multimedia> multimediaCollection;

}