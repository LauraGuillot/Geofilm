/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Laura
 */
@Entity
@Table(name = "picture", catalog = "geofilm", schema = "geofilm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Picture.findAll", query = "SELECT p FROM Picture p"),
    @NamedQuery(name = "Picture.findByPictureId", query = "SELECT p FROM Picture p WHERE p.pictureId = :pictureId")})
public class Picture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "picture_id")
    private Integer pictureId;
    @JoinColumn(name = "multimedia_id", referencedColumnName = "multimedia_id")
    @ManyToOne(optional = false)
    private Multimedia multimediaId;
    @JoinColumn(name = "source_id", referencedColumnName = "source_id")
    @ManyToOne(optional = false)
    private Source sourceId;

    public Picture() {
    }

    public Picture(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Multimedia getMultimediaId() {
        return multimediaId;
    }

    public void setMultimediaId(Multimedia multimediaId) {
        this.multimediaId = multimediaId;
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
        hash += (pictureId != null ? pictureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Picture)) {
            return false;
        }
        Picture other = (Picture) object;
        if ((this.pictureId == null && other.pictureId != null) || (this.pictureId != null && !this.pictureId.equals(other.pictureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Picture[ pictureId=" + pictureId + " ]";
    }
    
}
