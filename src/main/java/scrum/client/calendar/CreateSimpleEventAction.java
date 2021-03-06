package scrum.client.calendar;

import ilarkesto.core.scope.Scope;
import scrum.client.common.TooltipBuilder;
import scrum.client.workspace.ProjectWorkspaceWidgets;

public class CreateSimpleEventAction extends GCreateSimpleEventAction {

	@Override
	public String getLabel() {
		return "Create Event";
	}

	@Override
	public String getTooltip() {
		TooltipBuilder tb = new TooltipBuilder("Create new Event on the date selected.");
		if (!getCurrentProject().isScrumTeamMember(getCurrentUser()))
			tb.addRemark(TooltipBuilder.NOT_SCRUMTEAM);

		return tb.getTooltip();
	}

	@Override
	public boolean isExecutable() {
		return true;
	}

	@Override
	public boolean isPermitted() {
		if (!getCurrentProject().isScrumTeamMember(getCurrentUser())) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		SimpleEvent event = new SimpleEvent(getCurrentProject(), Scope.get()
				.getComponent(ProjectWorkspaceWidgets.class).getCalendar().getSelectedDate());
		getDao().createSimpleEvent(event);
		Scope.get().getComponent(ProjectWorkspaceWidgets.class).showCalendar(event);
	}

}