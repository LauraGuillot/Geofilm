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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "multimedia")
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
    @NamedQuery(name = "Multimedia.findByMultimediaLike", query = "SELECT m FROM Multimedia m WHERE m.multimediaLike = :multimediaLike"),
    @NamedQuery(name = "Multimedia.findByMultimediaDislike", query = "SELECT m FROM Multimedia m WHERE m.multimediaDislike = :multimediaDislike"),
    @NamedQuery(name = "Multimedia.findByMultimediaIsSignaled", query = "SELECT m FROM Multimedia m WHERE m.multimediaIsSignaled = :multimediaIsSignaled")})
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
    @Column(name = "multimedia_like")
    private int multimediaLike;
    @Basic(optional = false)
    @Column(name = "multimedia_dislike")
    private int multimediaDislike;
    @Basic(optional = false)
    @Column(name = "multimedia_is_signaled")
    private int multimediaIsSignaled;
    @ManyToMany(mappedBy = "multimediaCollection")
    private Collection<Person> personCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "multimediaId")
    private Collection<Sequence> sequenceCollection;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "publisher", referencedColumnName = "person_id")
    @ManyToOne(optional = false)
    private Person publisher;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "multimediaId")
    private Collection<Sound> soundCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "multimediaId")
    private Collection<Picture> pictureCollection;

    public Multimedia() {
    }

    public Multimedia(Integer multimediaId) {
        this.multimediaId = multimediaId;
    }

    public Multimedia(Integer multimediaId, String multimediaTitle, String multimediaDescription, String multimediaPath, String multimediaUploadDate, int multimediaLike, int multimediaDislike, int multimediaIsSignaled) {
        this.multimediaId = multimediaId;
        this.multimediaTitle = multimediaTitle;
        this.multimediaDescription = multimediaDescription;
        this.multimediaPath = multimediaPath;
        this.multimediaUploadDate = multimediaUploadDate;
        this.multimediaLike = multimediaLike;
        this.multimediaDislike = multimediaDislike;
        this.multimediaIsSignaled = multimediaIsSignaled;
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

    public int getMultimediaLike() {
        return multimediaLike;
    }

    public void setMultimediaLike(int multimediaLike) {
        this.multimediaLike = multimediaLike;
    }

    public int getMultimediaDislike() {
        return multimediaDislike;
    }

    public void setMultimediaDislike(int multimediaDislike) {
        this.multimediaDislike = multimediaDislike;
    }

    public int getMultimediaIsSignaled() {
        return multimediaIsSignaled;
    }

    public void setMultimediaIsSignaled(int multimediaIsSignaled) {
        this.multimediaIsSignaled = multimediaIsSignaled;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @XmlTransient
    public Collection<Sequence> getSequenceCollection() {
        return sequenceCollection;
    }

    public void setSequenceCollection(Collection<Sequence> sequenceCollection) {
        this.sequenceCollection = sequenceCollection;
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

    @XmlTransient
    public Collection<Sound> getSoundCollection() {
        return soundCollection;
    }

    public void setSoundCollection(Collection<Sound> soundCollection) {
        this.soundCollection = soundCollection;
    }

    @XmlTransient
    public Collection<Picture> getPictureCollection() {
        return pictureCollection;
    }

    public void setPictureCollection(Collection<Picture> pictureCollection) {
        this.pictureCollection = pictureCollection;
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
