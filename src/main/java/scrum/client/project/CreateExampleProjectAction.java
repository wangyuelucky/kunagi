package scrum.client.project;

import ilarkesto.core.scope.Scope;

import java.util.List;

import scrum.client.common.TooltipBuilder;
import scrum.client.workspace.Ui;
import scrum.client.workspace.UsersWorkspaceWidgets;

public class CreateExampleProjectAction extends GCreateExampleProjectAction {

	@Override
	public String getLabel() {
		return "Create Example Project";
	}

	@Override
	public String getTooltip() {
		TooltipBuilder tb = new TooltipBuilder("Create a new example Project with some content.");
		if (!getCurrentUser().isAdmin() && getDao().getSystemConfig().isProjectCreationDisabled())
			tb.addRemark("Creating new projects is disabled.");
		return tb.getTooltip();
	}

	@Override
	public boolean isPermitted() {
		if (!getCurrentUser().isAdmin() && getDao().getSystemConfig().isProjectCreationDisabled()) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		Scope.get().getComponent(Ui.class).lock("Creating Example Project...");
		final List<Project> previousProjects = getDao().getProjects();
		new CreateExampleProjectServiceCall().execute(new Runnable() {

			@Override
			public void run() {
				Scope.get().getComponent(Ui.class).unlock();
				List<Project> newProjects = getDao().getProjects();
				newProjects.removeAll(previousProjects);
				if (!newProjects.isEmpty()) {
					Scope.get().getComponent(UsersWorkspaceWidgets.class).getProjectSelector()
							.select(newProjects.get(0));
				}
			}
		});
	}

}