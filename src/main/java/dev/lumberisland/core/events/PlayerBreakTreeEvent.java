package dev.lumberisland.core.events;

import dev.lumberisland.core.events.system.PluginEvent;
import dev.lumberisland.core.objects.Tree;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class PlayerBreakTreeEvent implements PluginEvent<PlayerBreakTreeEvent> {

    private static final Set<Consumer<PlayerBreakTreeEvent>> events = new HashSet<>();

    private final Player player;

    public Player getPlayer() {
        return player;
    }

    public Tree getTree() {
        return tree;
    }

    private final Tree tree;

    public PlayerBreakTreeEvent(Player player, Tree tree) {
        this.player = player;
        this.tree = tree;
    }

    @Override
    public PlayerBreakTreeEvent getEvent() {
        return this;
    }

    @Override
    public Set<Consumer<PlayerBreakTreeEvent>> getEventList() {
        return events;
    }
}
