package scrum.client.project;

import scrum.client.ScrumGwtApplication;

public class RemoveRequirementFromSprintAction extends GRemoveRequirementFromSprintAction {

	protected RemoveRequirementFromSprintAction(Requirement requirement) {
		super(requirement);
	}

	@Override
	public String getLabel() {
		return "Remove from Sprint";
	}

	@Override
	public String getTooltip() {
		return "Remove this requirement from Sprint.";
	}

	@Override
	public boolean isExecutable() {
		return requirement.isSprintSet();
	}

	@Override
	protected void onExecute() {
		requirement.setSprint(null);
		ScrumGwtApplication.get().postSystemMessage(
			getUser().getName() + " removed requirement " + requirement.getReference() + " from current sprint.", true);
	}

}
