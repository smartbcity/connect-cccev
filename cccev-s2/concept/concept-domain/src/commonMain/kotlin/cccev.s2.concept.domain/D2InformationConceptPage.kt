package cccev.s2.concept.domain

/**
 * An InformationConcept represents a piece of information on which Requirements can be applied,
 * and provided by an Evidence or auto-computed from other InformationConcepts. <br />
 * See https://semiceu.github.io/CCCEV/releases/2.00/#Information%20Concept
 * @d2 page
 * @title Core/Information Concept
 */
interface D2InformationConceptPage

/**
 * @d2 service
 * @parent [D2InformationConceptPage]
 */
interface D2InformationConceptService: InformationConceptAggregate, InformationConceptFinder
