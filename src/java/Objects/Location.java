/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId"),
    @NamedQuery(name = "Location.findByLocationThegeom", query = "SELECT l FROM Location l WHERE l.locationThegeom = :locationThegeom"),
    @NamedQuery(name = "Location.findByLocationAddress", query = "SELECT l FROM Location l WHERE l.locationAddress = :locationAddress"),
    @NamedQuery(name = "Location.findByLocationCity", query = "SELECT l FROM Location l WHERE l.locationCity = :locationCity"),
    @NamedQuery(name = "Location.findByLocationPostalCode", query = "SELECT l FROM Location l WHERE l.locationPostalCode = :locationPostalCode"),
    @NamedQuery(name = "Location.findByLocationCountry", query = "SELECT l FROM Location l WHERE l.locationCountry = :locationCountry"),
    @NamedQuery(name = "Location.findByLocationAddressComplement", query = "SELECT l FROM Location l WHERE l.locationAddressComplement = :locationAddressComplement")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "location_id")
    private Integer locationId;
    @Column(name = "location_thegeom")
    private String locationThegeom;
    @Column(name = "location_address")
    private String locationAddress;
    @Column(name = "location_city")
    private String locationCity;
    @Column(name = "location_postal_code")
    private String locationPostalCode;
    @Column(name = "location_country")
    private String locationCountry;
    @Column(name = "location_address_complement")
    private String locationAddressComplement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private Collection<Multimedia> multimediaCollection;

    public Location() {
    }

    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationThegeom() {
        return locationThegeom;
    }

    public void setLocationThegeom(String locationThegeom) {
        this.locationThegeom = locationThegeom;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationPostalCode() {
        return locationPostalCode;
    }

    public void setLocationPostalCode(String locationPostalCode) {
        this.locationPostalCode = locationPostalCode;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getLocationAddressComplement() {
        return locationAddressComplement;
    }

    public void setLocationAddressComplement(String locationAddressComplement) {
        this.locationAddressComplement = locationAddressComplement;
    }

    @XmlTransient
    public Collection<Multimedia> getMultimediaCollection() {
        return multimediaCollection;
    }

    public void setMultimediaCollection(Collection<Multimedia> multimediaCollection) {
        this.multimediaCollection = multimediaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Location[ locationId=" + locationId + " ]";
    }
    
}
