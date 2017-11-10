package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.group.Group;
import seedu.address.model.group.GroupName;
import seedu.address.model.group.ReadOnlyGroup;
import seedu.address.model.person.ReadOnlyPerson;

import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.PERSON_WITHOUT_ADDRESS;


public class GroupBuilder {
    public static final String DEFAULT_GROUP_NAME = "Sample Group 1";
    public static List<ReadOnlyPerson> DEFAULT_GROUP_MEMBER_LIST = new ArrayList<>(Arrays.asList(ALICE));

    private Group group;

    public GroupBuilder() {
        try {
            GroupName defaultName = new GroupName(DEFAULT_GROUP_NAME);
            List<ReadOnlyPerson> groupMembersList = DEFAULT_GROUP_MEMBER_LIST;
            this.group = new Group(defaultName, groupMembersList);
        } catch (IllegalValueException e) {
            throw new AssertionError("Default group's values are invalid.");
        }
    }

    /**
     * Initializes the GroupBuilder with the data of {@code groupToCopy}.
     */
    public GroupBuilder(ReadOnlyGroup groupToCopy) {
        this.group = new Group(groupToCopy);
    }

    /**
     * Sets the {@code groupName} of the {@code Group} that we are building.
     */
    public GroupBuilder withGroupName(String groupName) {
        try {
            this.group.setGroupName(new GroupName(groupName));
        } catch (IllegalValueException e) {
            throw new IllegalArgumentException("group name is expected to be unique");
        }
        return this;
    }

    /**
     * Sets the {@code memberList} of the {@code Group} that we are building.
     */
    public GroupBuilder withGroupMembers(List<ReadOnlyPerson> memberList) {
        this.group.setGroupMembers(memberList);
        return this;
    }

    public Group build() {
        return this.group;
    }
}
