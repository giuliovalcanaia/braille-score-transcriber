package br.com.braille.xml.score.scorepartwise.part.measure.harmony;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum Kind {

    // Triad: major third, augmented fifth.
    @XmlEnumValue("augmented")
    AUGMENTED,

    // Seventh: augmented triad, minor seventh.
    @XmlEnumValue("augmented-seventh")
    AUGMENTED_SEVENTH,

    // Triad: minor third, diminished fifth.
    @XmlEnumValue("diminished")
    DIMINISHED,

    // Seventh: diminished triad, diminished seventh.
    @XmlEnumValue("diminished-seventh")
    DIMINISHED_SEVENTH,

    // Seventh: major triad, minor seventh.
    @XmlEnumValue("dominant")
    DOMINANT,

    // 11th: dominant-ninth, perfect 11th.
    @XmlEnumValue("dominant-11th")
    DOMINANT_ELEVENTH,

    // 13th: dominant-11th, major 13th.
    @XmlEnumValue("dominant-13th")
    DOMINANT_THIRTEENTH,

    // Ninth: dominant, major ninth.
    @XmlEnumValue("dominant-ninth")
    DOMINANT_NINTH,

    // Functional French sixth.
    @XmlEnumValue("French")
    FRENCH,

    // Functional German sixth.
    @XmlEnumValue("German")
    GERMAN,

    // Seventh: diminished triad, minor seventh.
    @XmlEnumValue("half-diminished")
    HALF_DIMINISHED,

    // Functional Italian sixth.
    @XmlEnumValue("Italian")
    ITALIAN,

    // Triad: major third, perfect fifth.
    @XmlEnumValue("major")
    MAJOR,

    // 11th: major-ninth, perfect 11th.
    @XmlEnumValue("major-11th")
    MAJOR_ELEVENTH,

    // 13th: major-11th, major 13th.
    @XmlEnumValue("major-13th")
    MAJOR_THIRTEENTH,

    // Seventh: minor triad, major seventh.
    @XmlEnumValue("major-minor")
    MAJOR_MINOR,

    // Ninth: major-seventh, major ninth.
    @XmlEnumValue("major-ninth")
    MAJOR_NINTH,

    // Seventh: major triad, major seventh.
    @XmlEnumValue("major-seventh")
    MAJOR_SEVENTH,

    // Sixth: major triad, added sixth.
    @XmlEnumValue("major-sixth")
    MAJOR_SIXTH,

    // Triad: minor third, perfect fifth.
    @XmlEnumValue("minor")
    MINOR,

    // 11th: minor-ninth, perfect 11th.
    @XmlEnumValue("minor-11th")
    MINOR_ELEVENTH,

    // 13th: minor-11th, major 13th.
    @XmlEnumValue("minor-13th")
    MINOR_THIRTEENTH,

    // Ninth: minor-seventh, major ninth.
    @XmlEnumValue("minor-ninth")
    MINOR_NINTH,

    // Seventh: minor triad, minor seventh.
    @XmlEnumValue("minor-seventh")
    MINOR_SEVENTH,

    // Sixth: minor triad, added sixth.
    @XmlEnumValue("minor-sixth")
    MINOR_SIXTH,

    // Functional Neapolitan sixth.
    @XmlEnumValue("Neapolitan")
    NEAPOLITAN,

    // Used to explicitly encode the absence of chords or functional harmony. In this case, the <root> <numeral>, or <function> element has no meaning. When using the <root> or <numeral> element, the <root-step> or <numeral-step> text attribute should be set to the empty string to keep the root or numeral from being displayed.
    @XmlEnumValue("none")
    NONE,

    // Used when the harmony is entirely composed of add elements.
    @XmlEnumValue("other")
    OTHER,

    // Pedal-point bass
    @XmlEnumValue("pedal")
    PEDAL,

    // Perfect fifth.
    @XmlEnumValue("power")
    POWER,

    // Suspended: perfect fourth, perfect fifth.
    @XmlEnumValue("suspended-fourth")
    SUSPENDED_FOURTH,

    // Suspended: major second, perfect fifth.
    @XmlEnumValue("suspended-second")
    SUSPENDED_SECOND,

    // Augmented fourth, augmented sixth, augmented ninth.
    @XmlEnumValue("Tristan")
    TRISTAN
}
