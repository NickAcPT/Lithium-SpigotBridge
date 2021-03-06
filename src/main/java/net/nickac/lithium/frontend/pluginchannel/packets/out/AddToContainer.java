package net.nickac.lithium.frontend.pluginchannel.packets.out;

import net.nickac.lithium.backend.controls.LContainer;
import net.nickac.lithium.backend.controls.LControl;
import net.nickac.lithium.backend.other.LithiumConstants;
import net.nickac.lithium.backend.serializer.SerializationUtils;
import net.nickac.lithium.frontend.pluginchannel.packets.abstracts.PacketOut;

import java.util.Arrays;
import java.util.List;

public class AddToContainer implements PacketOut {

    private LContainer lContainer;
    private LControl lControl;

    public AddToContainer(LContainer lContainer, LControl lControl) {
        this.lContainer = lContainer;
        this.lControl = lControl;
    }

    @Override
    public List<String> execute() {
        return Arrays.asList(key(), String.valueOf(lContainer.getUUID()), SerializationUtils.objectToString(lControl));
    }

    @Override
    public String key() {
        return LithiumConstants.TO_CLIENT.ADD_TO_CONTAINER;
    }
}
