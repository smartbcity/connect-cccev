package cccev.s2.certification.domain

import cccev.s2.requirement.domain.RequirementAggregate
import cccev.s2.requirement.domain.RequirementFinder

/**
 * An certification is a task or set of tasks that need to be completed in order to
 * achieve a particular goal or objective. Certifications can be performed by individuals or teams,
 * and they can range from simple, routine tasks to complex, multi-step processes.
 *
 * @d2 page
 * @title Certification
 *
 */
interface D2CertificationPage
/**
 * @d2 service
 * @parent [D2RequirementPage]
 */
interface D2RequirementService: RequirementAggregate, RequirementFinder
