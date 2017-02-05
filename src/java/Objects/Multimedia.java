/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "multimedia", catalog = "geofilm", schema = "geofilm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multimedia.findAll", query = "SELECT m FROM Multimedia m"),
    @NamedQuery(name = "Multimedia.findByMultimediaId", query = "SELECT m FROM Multimedia m WHERE m.multimediaId = :multimediaId"),
    @NamedQuery(name = "Multimedia.findByMultimediaTitle", query = "SELECT m FROM Multimedia m WHERE m.multimediaTitle = :multimediaTitle"),
    @NamedQuery(name = "Multimedia.findByMultimediaDescription", query = "SELECT m FROM Multimedia m WHERE m.multimediaDescription = :multimediaDescription"),
    @NamedQuery(name = "Multimedia.findByMultimediaPath", query = "SELECT m FROM Multimedia m WHERE m.multimediaPath = :multimediaPath"),
    @NamedQuery(name = "Multimedia.findByMultimediaUploadDate", query = "SELECT m FROM Multimedia m WHERE m.multimediaUploadDate = :multimediaUploadDate"),
    @NamedQuery(name = "Multimedia.findByMultimediaFormat", query = "SELECT m FROM Multimedia m WHERE m.multimediaFormat = :multimediaFormat"),
    @NamedQuery(name = "Multimedia.findByMultimediaLanguage", query = "SELECT m FROM Multimedia m WHERE m.multimediaLanguage = :multimediaLanguage"),
    @NamedQuery(name = "Multimedia.findByMultimediaType", query = "SELECT m FROM Multimedia m WHERE m.multimediaType = :multimediaType")})
public class Multimedia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "multimedia_id")
    private Integer multimediaId;
    @Basic(optional = false)
    @Column(name = "multimedia_title")
    private String multimediaTitle;
    @Basic(optional = false)
    @Column(name = "multimedia_description")
    private String multimediaDescription;
    @Basic(optional = false)
    @Column(name = "multimedia_path")
    private String multimediaPath;
    @Basic(optional = false)
    @Column(name = "multimedia_upload_date")
    private String multimediaUploadDate;
    @Column(name = "multimedia_format")
    private String multimediaFormat;
    @Column(name = "multimedia_language")
    private String multimediaLanguage;
    @Basic(optional = false)
    @Column(name = "multimedia_type")
    private String multimediaType;
    @JoinTable(name = "badlocation", joinColumns = {
        @JoinColumn(name = "multimedia_id", referencedColumnName = "multimedia_id")}, inverseJoinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "person_id")})
    @ManyToMany
    private Collection<Person> personCollection;
    @JoinTable(name = "disliked", joinColumns = {
        @JoinColumn(name = "multimedia_id", referencedColumnName = "multimedia_id")}, inverseJoinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "person_id")})
    @ManyToMany
    private Collection<Person> personCollection1;
    @ManyToMany(mappedBy = "multimediaCollection2")
    private Collection<Person> personCollection2;
    @JoinTable(name = "liked", joinColumns = {
        @JoinColumn(name = "multimedia_id", referencedColumnName = "multimedia_id")}, inverseJoinColumns = {
        @JoinColumn(name = "person_id", referencedColumnName = "person_id")})
    @ManyToMany
    private Collection<Person> personCollection3;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "publisher", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person publisher;
    @JoinColumn(name = "source_id", referencedColumnName = "source_id")
    @ManyToOne(optional = false)
    private Source sourceId;

    public Multimedia() {
    }

    public Multimedia(Integer multimediaId) {
        this.multimediaId = multimediaId;
    }

    public Multimedia(Integer multimediaId, String multimediaTitle, String multimediaDescription, String multimediaPath, String multimediaUploadDate, String multimediaType) {
        this.multimediaId = multimediaId;
        this.multimediaTitle = multimediaTitle;
        this.multimediaDescription = multimediaDescription;
        this.multimediaPath = multimediaPath;
        this.multimediaUploadDate = multimediaUploadDate;
        this.multimediaType = multimediaType;
    }

    public Integer getMultimediaId() {
        return multimediaId;
    }

    public void setMultimediaId(Integer multimediaId) {
        this.multimediaId = multimediaId;
    }

    public String getMultimediaTitle() {
        return multimediaTitle;
    }

    public void setMultimediaTitle(String multimediaTitle) {
        this.multimediaTitle = multimediaTitle;
    }

    public String getMultimediaDescription() {
        return multimediaDescription;
    }

    public void setMultimediaDescription(String multimediaDescription) {
        this.multimediaDescription = multimediaDescription;
    }

    public String getMultimediaPath() {
        return multimediaPath;
    }

    public void setMultimediaPath(String multimediaPath) {
        this.multimediaPath = multimediaPath;
    }

    public String getMultimediaUploadDate() {
        return multimediaUploadDate;
    }

    public void setMultimediaUploadDate(String multimediaUploadDate) {
        this.multimediaUploadDate = multimediaUploadDate;
    }

    public String getMultimediaFormat() {
        return multimediaFormat;
    }

    public void setMultimediaFormat(String multimediaFormat) {
        this.multimediaFormat = multimediaFormat;
    }

    public String getMultimediaLanguage() {
        return multimediaLanguage;
    }

    public void setMultimediaLanguage(String multimediaLanguage) {
        this.multimediaLanguage = multimediaLanguage;
    }

    public String getMultimediaType() {
        return multimediaType;
    }

    public void setMultimediaType(String multimediaType) {
        this.multimediaType = multimediaType;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection1() {
        return personCollection1;
    }

    public void setPersonCollection1(Collection<Person> personCollection1) {
        this.personCollection1 = personCollection1;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection2() {
        return personCollection2;
    }

    public void setPersonCollection2(Collection<Person> personCollection2) {
        this.personCollection2 = personCollection2;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection3() {
        return personCollection3;
    }

    public void setPersonCollection3(Collection<Person> personCollection3) {
        this.personCollection3 = personCollection3;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public Person getPublisher() {
        return publisher;
    }

    public void setPublisher(Person publisher) {
        this.publisher = publisher;
    }

    public Source getSourceId() {
        return sourceId;
    }

    public void setSourceId(Source sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (multimediaId != null ? multimediaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multimedia)) {
            return false;
        }
        Multimedia other = (Multimedia) object;
        if ((this.multimediaId == null && other.multimediaId != null) || (this.multimediaId != null && !this.multimediaId.equals(other.multimediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Multimedia[ multimediaId=" + multimediaId + " ]";
    }
    
}
