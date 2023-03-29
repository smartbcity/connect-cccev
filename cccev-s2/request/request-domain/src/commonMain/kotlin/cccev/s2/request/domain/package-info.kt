package cccev.s2.request.domain

import cccev.s2.requirement.domain.RequirementAggregate
import cccev.s2.requirement.domain.RequirementFinder

/**
 * An request is a task or set of tasks that need to be completed in order to
 * achieve a particular goal or objective. Requests can be performed by individuals or teams,
 * and they can range from simple, routine tasks to complex, multi-step processes.
 *
 * @d2 page
 * @title Request
 *
 */
interface D2RequestPage
/**
 * @d2 service
 * @parent [D2RequirementPage]
 */
interface D2RequirementService: RequirementAggregate, RequirementFinder
