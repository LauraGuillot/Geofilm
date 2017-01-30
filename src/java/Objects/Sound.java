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
@Table(name = "sound", catalog = "geofilm", schema = "geofilm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sound.findAll", query = "SELECT s FROM Sound s"),
    @NamedQuery(name = "Sound.findBySoundId", query = "SELECT s FROM Sound s WHERE s.soundId = :soundId")})
public class Sound implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sound_id")
    private Integer soundId;
    @JoinColumn(name = "multimedia_id", referencedColumnName = "multimedia_id")
    @ManyToOne(optional = false)
    private Multimedia multimediaId;
    @JoinColumn(name = "source_id", referencedColumnName = "source_id")
    @ManyToOne(optional = false)
    private Source sourceId;

    public Sound() {
    }

    public Sound(Integer soundId) {
        this.soundId = soundId;
    }

    public Integer getSoundId() {
        return soundId;
    }

    public void setSoundId(Integer soundId) {
        this.soundId = soundId;
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
        hash += (soundId != null ? soundId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sound)) {
            return false;
        }
        Sound other = (Sound) object;
        if ((this.soundId == null && other.soundId != null) || (this.soundId != null && !this.soundId.equals(other.soundId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Objects.Sound[ soundId=" + soundId + " ]";
    }
    
}
