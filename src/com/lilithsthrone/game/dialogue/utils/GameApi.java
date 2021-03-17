package com.lilithsthrone.game.dialogue.utils;

import com.lilithsthrone.game.Game;
import com.lilithsthrone.game.Properties;
import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.attributes.*;
import com.lilithsthrone.game.character.body.Body;
import com.lilithsthrone.game.character.body.CoverableArea;
import com.lilithsthrone.game.character.body.abstractTypes.*;
import com.lilithsthrone.game.character.body.coverings.AbstractBodyCoveringType;
import com.lilithsthrone.game.character.body.coverings.BodyCoveringCategory;
import com.lilithsthrone.game.character.body.tags.BodyPartTag;
import com.lilithsthrone.game.character.body.valueEnums.*;
import com.lilithsthrone.game.character.effects.AbstractPerk;
import com.lilithsthrone.game.character.effects.AbstractStatusEffect;
import com.lilithsthrone.game.character.fetishes.Fetish;
import com.lilithsthrone.game.character.fetishes.FetishDesire;
import com.lilithsthrone.game.character.npc.NPCFlagValue;
import com.lilithsthrone.game.character.persona.*;
import com.lilithsthrone.game.character.quests.Quest;
import com.lilithsthrone.game.character.quests.QuestLine;
import com.lilithsthrone.game.character.race.*;
import com.lilithsthrone.game.combat.Combat;
import com.lilithsthrone.game.combat.CombatBehaviour;
import com.lilithsthrone.game.combat.DamageType;
import com.lilithsthrone.game.combat.spells.Spell;
import com.lilithsthrone.game.combat.spells.SpellSchool;
import com.lilithsthrone.game.combat.spells.SpellUpgrade;
import com.lilithsthrone.game.dialogue.DialogueFlagValue;
import com.lilithsthrone.game.inventory.AbstractSetBonus;
import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.inventory.ItemGeneration;
import com.lilithsthrone.game.inventory.ItemTag;
import com.lilithsthrone.game.inventory.clothing.AbstractClothingType;
import com.lilithsthrone.game.inventory.item.AbstractItemType;
import com.lilithsthrone.game.inventory.weapon.AbstractWeaponType;
import com.lilithsthrone.game.occupantManagement.slave.SlavePermissionSetting;
import com.lilithsthrone.game.settings.ForcedFetishTendency;
import com.lilithsthrone.game.settings.ForcedTFTendency;
import com.lilithsthrone.game.sex.*;
import com.lilithsthrone.utils.colours.Colour;
import com.lilithsthrone.utils.time.DayPeriod;
import com.lilithsthrone.world.AbstractWorldType;
import com.lilithsthrone.world.Season;
import com.lilithsthrone.world.Weather;
import com.lilithsthrone.world.places.AbstractPlaceType;
import com.lilithsthrone.world.places.AbstractPlaceUpgrade;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class GameApi {
    public Game game;
    public Sex sex;
    public Combat combat;
    public Properties properties;
    public Random RND;
    public ItemGeneration itemGen;

    public List<GameCharacter> npcs;
    public List<GameCharacter> coms;

    public AbstractClothingType clothing;
    public Body targetedBody;
    public AbstractRace targetedRace;

    // Date/Time
    private final Map<String, DayOfWeek> _dow = new HashMap<>();

    // Items
    private final Map<String, AbstractWeaponType> _weaponType = new HashMap<>();
    private final Map<String, AbstractClothingType> _clothingType = new HashMap<>();
    private final Map<String, AbstractItemType> _itemType = new HashMap<>();
    private final Map<String, AbstractSetBonus> _setBonus = new HashMap<>();
    private final Map<String, ItemTag> _itemTag = new HashMap<>();
    private final Map<String, CoverableArea> _coverableArea = new HashMap<>();
    private final Map<String, InventorySlot> _inventorySlot = new HashMap<>();

    // Misc
    private final Map<String, Colour> _colour = new HashMap<>();

    // Bodies
    private final Map<String, AbstractRace> _race = new HashMap<>();
    private final Map<String, AbstractRacialBody> _racialBody = new HashMap<>();
    private final Map<String, RaceStage> _raceStage = new HashMap<>();
    private final Map<String, AbstractSubspecies> _subspecies = new HashMap<>();
    private final Map<String, LegConfiguration> _legConfiguration = new HashMap<>();
    private final Map<String, FootStructure> _footStructure = new HashMap<>();
    private final Map<String, GenitalArrangement> _genitalArrangement = new HashMap<>();
    private final Map<String, BodyMaterial> _bodyMaterial = new HashMap<>();
    private final Map<String, AbstractBodyCoveringType> _bodyCoveringType = new HashMap<>();
    private final Map<String, BodyCoveringCategory> _bodyCoveringCategory = new HashMap<>();
    private final Map<String, CoveringPattern> _coveringPattern = new HashMap<>();
    private final Map<String, CoveringModifier> _coveringModifier = new HashMap<>();
    private final Map<String, NippleShape> _nippleShape = new HashMap<>();
    private final Map<String, CumProduction> _cumProduction = new HashMap<>();
    private final Map<String, BodyPartTag> _bodyPartTag = new HashMap<>();
    private final Map<String, PenetrationModifier> _penetrationModifier = new HashMap<>();
    private final Map<String, OrificeModifier> _orificeModifier = new HashMap<>();
    private final Map<String, TongueModifier> _tongueModifier = new HashMap<>();
    private final Map<String, Muscle> _muscle = new HashMap<>();
    private final Map<String, BodySize> _bodySize = new HashMap<>();
    private final Map<String, BodyShape> _bodyShape = new HashMap<>();

    // Types
    private final Map<String, AbstractFluidType> _fluidType = new HashMap<>();
    private final Map<String, AbstractAntennaType> _antennaType = new HashMap<>();
    private final Map<String, AbstractAnusType> _anusType = new HashMap<>();
    private final Map<String, AbstractArmType> _armType = new HashMap<>();
    private final Map<String, AbstractAssType> _assType = new HashMap<>();
    private final Map<String, AbstractBreastType> _breastType = new HashMap<>();
    private final Map<String, AbstractEarType> _earType = new HashMap<>();
    private final Map<String, AbstractEyeType> _eyeType = new HashMap<>();
    private final Map<String, AbstractFaceType> _faceType = new HashMap<>();
    private final Map<String, AbstractFootType> _footType = new HashMap<>();
    private final Map<String, AbstractHairType> _hairType = new HashMap<>();
    private final Map<String, AbstractHornType> _hornType = new HashMap<>();
    private final Map<String, AbstractLegType> _legType = new HashMap<>();
    private final Map<String, AbstractMouthType> _mouthType = new HashMap<>();
    private final Map<String, AbstractNippleType> _nippleType = new HashMap<>();
    private final Map<String, AbstractPenisType> _penisType = new HashMap<>();
    private final Map<String, AbstractTorsoType> _torsoType = new HashMap<>();
    private final Map<String, AbstractTailType> _tailType = new HashMap<>();
    private final Map<String, AbstractTentacleType> _tentacleType = new HashMap<>();
    private final Map<String, AbstractTesticleType> _testicleType = new HashMap<>();
    private final Map<String, AbstractTongueType> _tongueType = new HashMap<>();
    private final Map<String, AbstractVaginaType> _vaginaType = new HashMap<>();
    private final Map<String, AbstractWingType> _wingType = new HashMap<>();
    private final Map<String, WingSize> _wingSize = new HashMap<>();

    // Effects & Persona
    private final Map<String, Fetish> _fetish = new HashMap<>();
    private final Map<String, FetishDesire> _fetishDesire = new HashMap<>();
    private final Map<String, PersonalityTrait> _personalityTrait = new HashMap<>();
    private final Map<String, Occupation> _occupation = new HashMap<>();
    private final Map<String, OccupationTag> _occupationTag = new HashMap<>();
    private final Map<String, AbstractPerk> _perk = new HashMap<>();
    private final Map<String, AbstractStatusEffect> _statusEffect = new HashMap<>();
    private final Map<String, AbstractAttribute> _attribute = new HashMap<>();

    // Combat
    private final Map<String, DamageType> _damageType = new HashMap<>();
    private final Map<String, SpellSchool> _spellSchool = new HashMap<>();
    private final Map<String, Spell> _spell = new HashMap<>();
    private final Map<String, SpellUpgrade> _spellUpgrade = new HashMap<>();
    private final Map<String, CombatBehaviour> _combatBehaviour = new HashMap<>();

    // Sex
    private final Map<String, SexParticipantType> _participantType = new HashMap<>();
    private final Map<String, SexAreaOrifice> _areaOrifice = new HashMap<>();
    private final Map<String, SexAreaPenetration> _areaPenetration = new HashMap<>();
    private final Map<String, GenericSexFlag> _sexFlag = new HashMap<>();

    // Other
    private final Map<String, Season> _season = new HashMap<>();
    private final Map<String, Weather> _weather = new HashMap<>();
    private final Map<String, DayPeriod> _dayPeriod = new HashMap<>();
    private final Map<String, DialogueFlagValue> _dialogueFlagValue = new HashMap<>();
    private final Map<String, NPCFlagValue> _npcFlag = new HashMap<>();
    private final Map<String, SlavePermissionSetting> _slavePermissionSetting = new HashMap<>();
    private final Map<String, QuestLine> _questLine = new HashMap<>();
    private final Map<String, Quest> _quest = new HashMap<>();
    private final Map<String, SexualOrientation> _sexualOrientation = new HashMap<>();
    private final Map<String, Femininity> _femininity = new HashMap<>();
    private final Map<String, AffectionLevel> _affectionLevel = new HashMap<>();
    private final Map<String, AffectionLevelBasic> _affectionLevelBasic = new HashMap<>();
    private final Map<String, ObedienceLevel> _obedienceLevel = new HashMap<>();
    private final Map<String, ObedienceLevelBasic> _obedienceLevelBasic = new HashMap<>();
    private final Map<String, Relationship> _relationship = new HashMap<>();
    private final Map<String, FurryPreference> _furryPreference = new HashMap<>();
    private final Map<String, ForcedTFTendency> _forcedTFTendency = new HashMap<>();
    private final Map<String, ForcedFetishTendency> _forcedFetishTendency = new HashMap<>();
    private final Map<String, AbstractWorldType> _worldType = new HashMap<>();
    private final Map<String, AbstractPlaceType> _placeType = new HashMap<>();
    private final Map<String, AbstractPlaceUpgrade> _placeUpgrade = new HashMap<>();

    public GameApi(Game game, Sex sex, Combat combat, Properties properties, Random random, ItemGeneration itemGeneration) {
        this.game = game;
        this.sex = sex;
        this.combat = combat;
        this.properties = properties;
        this.RND = random;
        this.itemGen = itemGeneration;
    }

    // Date/Time
    public DayOfWeek dow(String key) { return _dow.get(key); }
    void addDayOfWeek(String key, DayOfWeek value) { _dow.put(key, value); }

    // Items
    public AbstractWeaponType weapon(String key) { return _weaponType.get(key); }
    void addWeaponType(String key, AbstractWeaponType value) { _weaponType.put(key, value); }

    public AbstractClothingType clothing(String key) { return _clothingType.get(key); }
    void addClothingType(String key, AbstractClothingType value) { _clothingType.put(key, value); }

    public AbstractItemType item(String key) { return _itemType.get(key); }
    void addItemType(String key, AbstractItemType value) { _itemType.put(key, value); }

    public AbstractSetBonus setBonus(String key) { return _setBonus.get(key); }
    void addSetBonus(String key, AbstractSetBonus value) { _setBonus.put(key, value); }

    public ItemTag it(String key) { return _itemTag.get(key); }
    void addItemTag(String key, ItemTag value) { _itemTag.put(key, value); }

    public CoverableArea ca(String key) { return _coverableArea.get(key); }
    void addCoverableArea(String key, CoverableArea value) { _coverableArea.put(key, value); }

    public InventorySlot is(String key) { return _inventorySlot.get(key); }
    void addInventorySlot(String key, InventorySlot value) { _inventorySlot.put(key, value); }

    // Misc
    public Colour colour(String key) { return _colour.get(key); }
    void addColour(String key, Colour value) { _colour.put(key, value); }

    // Bodies
    public AbstractRace race(String key) { return _race.get(key); }
    void addRace(String key, AbstractRace value) { _race.put(key, value); }

    public AbstractRacialBody racialBody(String key) { return _racialBody.get(key); }
    void addRacialBody(String key, AbstractRacialBody value) { _racialBody.put(key, value); }

    public RaceStage raceStage(String key) { return _raceStage.get(key); }
    void addRaceStage(String key, RaceStage value) { _raceStage.put(key, value); }

    public AbstractSubspecies subspecies(String key) { return _subspecies.get(key); }
    void addSubspecies(String key, AbstractSubspecies value) { _subspecies.put(key, value); }

    public LegConfiguration legConfiguration(String key) { return _legConfiguration.get(key); }
    void addLegConfiguration(String key, LegConfiguration value) { _legConfiguration.put(key, value); }

    public FootStructure footStructure(String key) { return _footStructure.get(key); }
    void addFootStructure(String key, FootStructure value) { _footStructure.put(key, value); }

    public GenitalArrangement genitals(String key) { return _genitalArrangement.get(key); }
    void addGenitalArrangement(String key, GenitalArrangement value) { _genitalArrangement.put(key, value); }

    public BodyMaterial bodyMaterial(String key) { return _bodyMaterial.get(key); }
    void addBodyMaterial(String key, BodyMaterial value) { _bodyMaterial.put(key, value); }

    public AbstractBodyCoveringType bodyCoveringType(String key) { return _bodyCoveringType.get(key); }
    void addBodyCoveringType(String key, AbstractBodyCoveringType value) { _bodyCoveringType.put(key, value); }

    public BodyCoveringCategory bodyCoveringCategory(String key) { return _bodyCoveringCategory.get(key); }
    void addBodyCoveringCategory(String key, BodyCoveringCategory value) { _bodyCoveringCategory.put(key, value); }

    public CoveringPattern coveringPattern(String key) { return _coveringPattern.get(key); }
    void addCoveringPattern(String key, CoveringPattern value) { _coveringPattern.put(key, value); }

    public CoveringModifier coveringModifier(String key) { return _coveringModifier.get(key); }
    void addCoveringModifier(String key, CoveringModifier value) { _coveringModifier.put(key, value); }

    public NippleShape nippleShape(String key) { return _nippleShape.get(key); }
    void addNippleShape(String key, NippleShape value) { _nippleShape.put(key, value); }

    public CumProduction cumProduction(String key) { return _cumProduction.get(key); }
    void addCumProduction(String key, CumProduction value) { _cumProduction.put(key, value); }

    public BodyPartTag bodyPartTag(String key) { return _bodyPartTag.get(key); }
    void addBodyPartTag(String key, BodyPartTag value) { _bodyPartTag.put(key, value); }

    public PenetrationModifier penetrationModifier(String key) { return _penetrationModifier.get(key); }
    void addPenetrationModifier(String key, PenetrationModifier value) { _penetrationModifier.put(key, value); }

    public OrificeModifier orificeModifier(String key) { return _orificeModifier.get(key); }
    void addOrificeModifier(String key, OrificeModifier value) { _orificeModifier.put(key, value); }

    public TongueModifier tongueModifier(String key) { return _tongueModifier.get(key); }
    void addTongueModifier(String key, TongueModifier value) { _tongueModifier.put(key, value); }

    public Muscle muscle(String key) { return _muscle.get(key); }
    void addMuscle(String key, Muscle value) { _muscle.put(key, value); }

    public BodySize bodySize(String key) { return _bodySize.get(key); }
    void addBodySize(String key, BodySize value) { _bodySize.put(key, value); }

    public BodyShape bodyShape(String key) { return _bodyShape.get(key); }
    void addBodyShape(String key, BodyShape value) { _bodyShape.put(key, value); }

    // Types
    public AbstractFluidType fluidType(String key) { return _fluidType.get(key); }
    void addFluidType(String key, AbstractFluidType value) { _fluidType.put(key, value); }

    public AbstractAntennaType antennaType(String key) { return _antennaType.get(key); }
    void addAntennaType(String key, AbstractAntennaType value) { _antennaType.put(key, value); }

    public AbstractAnusType anusType(String key) { return _anusType.get(key); }
    void addAnusType(String key, AbstractAnusType value) { _anusType.put(key, value); }

    public AbstractArmType armType(String key) { return _armType.get(key); }
    void addArmType(String key, AbstractArmType value) { _armType.put(key, value); }

    public AbstractAssType assType(String key) { return _assType.get(key); }
    void addAssType(String key, AbstractAssType value) { _assType.put(key, value); }

    public AbstractBreastType breastType(String key) { return _breastType.get(key); }
    void addBreastType(String key, AbstractBreastType value) { _breastType.put(key, value); }

    public AbstractEarType earType(String key) { return _earType.get(key); }
    void addEarType(String key, AbstractEarType value) { _earType.put(key, value); }

    public AbstractEyeType eyeType(String key) { return _eyeType.get(key); }
    void addEyeType(String key, AbstractEyeType value) { _eyeType.put(key, value); }

    public AbstractFaceType faceType(String key) { return _faceType.get(key); }
    void addFaceType(String key, AbstractFaceType value) { _faceType.put(key, value); }

    public AbstractFootType footType(String key) { return _footType.get(key); }
    void addFootType(String key, AbstractFootType value) { _footType.put(key, value); }

    public AbstractHairType hairType(String key) { return _hairType.get(key); }
    void addHairType(String key, AbstractHairType value) { _hairType.put(key, value); }

    public AbstractHornType hornType(String key) { return _hornType.get(key); }
    void addHornType(String key, AbstractHornType value) { _hornType.put(key, value); }

    public AbstractLegType legType(String key) { return _legType.get(key); }
    void addLegType(String key, AbstractLegType value) { _legType.put(key, value); }

    public AbstractMouthType mouthType(String key) { return _mouthType.get(key); }
    void addMouthType(String key, AbstractMouthType value) { _mouthType.put(key, value); }

    public AbstractNippleType nippleType(String key) { return _nippleType.get(key); }
    void addNippleType(String key, AbstractNippleType value) { _nippleType.put(key, value); }

    public AbstractPenisType penisType(String key) { return _penisType.get(key); }
    void addPenisType(String key, AbstractPenisType value) { _penisType.put(key, value); }

    public AbstractTorsoType torsoType(String key) { return _torsoType.get(key); }
    void addTorsoType(String key, AbstractTorsoType value) { _torsoType.put(key, value); }

    public AbstractTailType tailType(String key) { return _tailType.get(key); }
    void addTailType(String key, AbstractTailType value) { _tailType.put(key, value); }

    public AbstractTentacleType tentacleType(String key) { return _tentacleType.get(key); }
    void addTentacleType(String key, AbstractTentacleType value) { _tentacleType.put(key, value); }

    public AbstractTesticleType testicleType(String key) { return _testicleType.get(key); }
    void addTesticleType(String key, AbstractTesticleType value) { _testicleType.put(key, value); }

    public AbstractTongueType tongueType(String key) { return _tongueType.get(key); }
    void addTongueType(String key, AbstractTongueType value) { _tongueType.put(key, value); }

    public AbstractVaginaType vaginaType(String key) { return _vaginaType.get(key); }
    void addVaginaType(String key, AbstractVaginaType value) { _vaginaType.put(key, value); }

    public AbstractWingType wingType(String key) { return _wingType.get(key); }
    void addWingType(String key, AbstractWingType value) { _wingType.put(key, value); }

    public int wingSize(String key) { return _wingSize.get(key).getValue(); }
    void addWingSize(String key, WingSize value) { _wingSize.put(key, value); }

    // Effects & Persona
    public Fetish fetish(String key) { return _fetish.get(key); }
    void addFetish(String key, Fetish value) { _fetish.put(key, value); }

    public FetishDesire fetishDesire(String key) { return _fetishDesire.get(key); }
    void addFetishDesire(String key, FetishDesire value) { _fetishDesire.put(key, value); }

    public PersonalityTrait personalityTrait(String key) { return _personalityTrait.get(key); }
    void addPersonalityTrait(String key, PersonalityTrait value) { _personalityTrait.put(key, value); }

    public Occupation occupation(String key) { return _occupation.get(key); }
    void addOccupation(String key, Occupation value) { _occupation.put(key, value); }

    public OccupationTag occupationTag(String key) { return _occupationTag.get(key); }
    void addOccupationTag(String key, OccupationTag value) { _occupationTag.put(key, value); }

    public AbstractPerk perk(String key) { return _perk.get(key); }
    void addPerk(String key, AbstractPerk value) { _perk.put(key, value); }

    public AbstractStatusEffect se(String key) { return _statusEffect.get(key); }
    void addStatusEffect(String key, AbstractStatusEffect value) { _statusEffect.put(key, value); }

    public AbstractAttribute attribute(String key) { return _attribute.get(key); }
    void addAttribute(String key, AbstractAttribute value) { _attribute.put(key, value); }

    // Combat
    public DamageType damageType(String key) { return _damageType.get(key); }
    void addDamageType(String key, DamageType value) { _damageType.put(key, value); }

    public SpellSchool spellSchool(String key) { return _spellSchool.get(key); }
    void addSpellSchool(String key, SpellSchool value) { _spellSchool.put(key, value); }

    public Spell spell(String key) { return _spell.get(key); }
    void addSpell(String key, Spell value) { _spell.put(key, value); }

    public SpellUpgrade spellUpgrade(String key) { return _spellUpgrade.get(key); }
    void addSpellUpgrade(String key, SpellUpgrade value) { _spellUpgrade.put(key, value); }

    public CombatBehaviour combatBehaviour(String key) { return _combatBehaviour.get(key); }
    void addCombatBehaviour(String key, CombatBehaviour value) { _combatBehaviour.put(key, value); }

    // Sex
    public SexParticipantType sexPt(String key) { return _participantType.get(key); }
    void addSexParticipantType(String key, SexParticipantType value) { _participantType.put(key, value); }

    public SexAreaOrifice orifice(String key) { return _areaOrifice.get(key); }
    void addSexAreaOrifice(String key, SexAreaOrifice value) { _areaOrifice.put(key, value); }

    public SexAreaPenetration penetration(String key) { return _areaPenetration.get(key); }
    void addSexAreaPenetration(String key, SexAreaPenetration value) { _areaPenetration.put(key, value); }

    public GenericSexFlag sexFlag(String key) { return _sexFlag.get(key); }
    void addGenericSexFlag(String key, GenericSexFlag value) { _sexFlag.put(key, value); }

    // Other
    public Season season(String key) { return _season.get(key); }
    void addSeason(String key, Season value) { _season.put(key, value); }

    public Weather weather(String key) { return _weather.get(key); }
    void addWeather(String key, Weather value) { _weather.put(key, value); }

    public DayPeriod dayPeriod(String key) { return _dayPeriod.get(key); }
    void addDayPeriod(String key, DayPeriod value) { _dayPeriod.put(key, value); }

    public DialogueFlagValue flag(String key) { return _dialogueFlagValue.get(key); }
    void addDialogueFlagValue(String key, DialogueFlagValue value) { _dialogueFlagValue.put(key, value); }

    public NPCFlagValue npcFlag(String key) { return _npcFlag.get(key); }
    void addNPCFlagValue(String key, NPCFlagValue value) { _npcFlag.put(key, value); }

    public SlavePermissionSetting slavePermissionSetting(String key) { return _slavePermissionSetting.get(key); }
    void addSlavePermissionSetting(String key, SlavePermissionSetting value) { _slavePermissionSetting.put(key, value); }

    public QuestLine questLine(String key) { return _questLine.get(key); }
    void addQuestLine(String key, QuestLine value) { _questLine.put(key, value); }

    public Quest quest(String key) { return _quest.get(key); }
    void addQuest(String key, Quest value) { _quest.put(key, value); }

    public SexualOrientation orientation(String key) { return _sexualOrientation.get(key); }
    void addSexualOrientation(String key, SexualOrientation value) { _sexualOrientation.put(key, value); }

    public Femininity femininity(String key) { return _femininity.get(key); }
    void addFemininity(String key, Femininity value) { _femininity.put(key, value); }

    public AffectionLevel affection(String key) { return _affectionLevel.get(key); }
    void addAffectionLevel(String key, AffectionLevel value) { _affectionLevel.put(key, value); }

    public AffectionLevelBasic affectionBasic(String key) { return _affectionLevelBasic.get(key); }
    void addAffectionLevelBasic(String key, AffectionLevelBasic value) { _affectionLevelBasic.put(key, value); }

    public ObedienceLevel obedience(String key) { return _obedienceLevel.get(key); }
    void addObedienceLevel(String key, ObedienceLevel value) { _obedienceLevel.put(key, value); }

    public ObedienceLevelBasic obedienceBasic(String key) { return _obedienceLevelBasic.get(key); }
    void addObedienceLevelBasic(String key, ObedienceLevelBasic value) { _obedienceLevelBasic.put(key, value); }

    public Relationship relationship(String key) { return _relationship.get(key); }
    void addRelationship(String key, Relationship value) { _relationship.put(key, value); }

    public FurryPreference furryPref(String key) { return _furryPreference.get(key); }
    void addFurryPreference(String key, FurryPreference value) { _furryPreference.put(key, value); }

    public ForcedTFTendency forcedTF(String key) { return _forcedTFTendency.get(key); }
    void addForcedTFTendency(String key, ForcedTFTendency value) { _forcedTFTendency.put(key, value); }

    public ForcedFetishTendency forcedFetish(String key) { return _forcedFetishTendency.get(key); }
    void addForcedFetishTendency(String key, ForcedFetishTendency value) { _forcedFetishTendency.put(key, value); }

    public AbstractWorldType worldType(String key) { return _worldType.get(key); }
    void addWorldType(String key, AbstractWorldType value) { _worldType.put(key, value); }

    public AbstractPlaceType placeType(String key) { return _placeType.get(key); }
    void addPlaceType(String key, AbstractPlaceType value) { _placeType.put(key, value); }

    public AbstractPlaceUpgrade placeUpgrade(String key) { return _placeUpgrade.get(key); }
    void addPlaceUpgrade(String key, AbstractPlaceUpgrade value) { _placeUpgrade.put(key, value); }

    // Some more shortcut getters. These are necessary to keep the XML syntax consistent, since
    // text substitutions don't use the parser system. Probably not something that should stick
    // around longer than necessary.
    // TODO: Remove these when feasible.
    public GameCharacter com() { return (GameCharacter)coms.toArray()[0]; }
    public GameCharacter npc() { return (GameCharacter)npcs.toArray()[0]; }
    public GameCharacter npc2() { return (GameCharacter)npcs.toArray()[1]; }
    public GameCharacter npc3() { return (GameCharacter)npcs.toArray()[2]; }
    public GameCharacter pc() { return game.getPlayer(); }
}
