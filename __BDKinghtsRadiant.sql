SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
DROP DATABASE IF EXISTS knights_radiant;
CREATE DATABASE IF NOT EXISTS knights_radiant DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE knights_radiant;
/*
DROP TABLE IF EXISTS surges;
CREATE TABLE IF NOT EXISTS surges (
        id INT(11) NOT NULL AUTO_INCREMENT,
        name VARCHAR(45) NOT NULL,
        description VARCHAR(255),
        ideal ENUM('NO_IDEAL', 'FIRST_IDEAL', 'SECOND_IDEAL', 'THIRD_IDEAL', 'FOURTH_IDEAL', 'FIFTH_IDEAL'),
        PRIMARY KEY (id)
) ENGINE=InnoDB;

TRUNCATE TABLE surges;
*/
INSERT INTO surges(name, description, ideal) VALUES
	('Adhesion', 'The Surge of Adhesion can be manipulated to bind things together.', 0),
	('Gravitation', "The Surge of Gravitation can be manipulated to change the direction and strength of an object's gravitational attraction.", 2),
	('Division', 'The Surge of Division can be manipulated to have power over destruction and decay.', 3),
	('Abrasion', 'The Surge of Abrasion can be manipulated to alter the frictional force between two surfaces.', 1),
	('Progression', 'The Surge of Progression can be manipulated to alter the growth and healing of organisms.', 2),
	('Ilumination', 'The Surge of Ilumination can be manipulated to create auditory and visual ilusions.', 0),
	('Transformation', 'The Surge of Transformation can be manipulated to change an object into one of the ten essences.', 0),
	('Transportation', 'The Surge of Transportation can be manipulated to achieve realmatic transition.', 2),
	('Cohesion', 'The Surge of Cohesion can be manipulated to alter objects at a molecular level.', 1),
	('Tension', 'The Surge of Tension can be manipulated to alter the stiffness of an object.', 2);

/*
DROP TABLE IF EXISTS radiantOrders;
CREATE TABLE IF NOT EXISTS radiantOrders (
        id INT(11) NOT NULL AUTO_INCREMENT,
        name VARCHAR(45) NOT NULL,
        sprenType VARCHAR(45),
        description VARCHAR(255),
        attributes VARCHAR(45),
        PRIMARY KEY (id)
) ENGINE=InnoDB;

TRUNCATE TABLE radiantOrders;
*/
INSERT INTO radiantOrders(name, herald, archetype, gemstone, sprenType, attributes, color, oathTheme, description) VALUES
	('Windrunners', 'Jezerezeh', 'King', 'Sapphire', 'Honorspren', 'Protecting and leading', '#193460', 'Windrunner oaths are themed toward protection, particularly defending innocents or those who are unable to protect themselves.', 'The Windrunners tend to attract “big sibling” types, who seek to protect the defenseless, but also enjoy action and fighting for what they believe in. They’re primarily scouts, though they often work as special forces groups, able to deliver teams of Radiants behind enemy lines for secret missions. They tend to be the most like conventional soldiers, believing in structures of command, team dynamics, and the importance of a squad of brothers and sisters. They often have larger numbers of squires than other Orders and focus more than any other Order on mastering their weapons.'),
	('Skybreakers', 'Nalan', 'Judge', 'Smokestone', 'Highspren', 'Just and confident', '#5F5D67', 'Skybreaker oaths are themed toward justice, fighting for causes, and enforcing social rules. They generally reinforce the importance of moral codes, legal structures, and similar boundaries that protect civilization.', 'The Skybreakers were the enforcers of the Knights Radiant, often tasked with keeping the peace, policing the other Orders, and making certain that dangerous or dark forces in the world were contained. This sometimes gave them a bad reputation among the more free-thinking Orders of Knights, but the Skybreakers (at their best) were not merciless. They were the ones who believed that nobody, not even a Radiant, should be above being questioned. They were the ones that did the sometimes tough job of making certain that the Orders didn’t abuse their power to become tyrants, as the Skybreakers saw that those with powers could easily oppress those who had none. They tend to attract those who believe in the importance of legal code, those who have strong moral codes of their own, and those who think the best defense against anarchy are things like patriotism, moral fiber, and rules to govern behavior. Note that the current incarnation, led by the Herald Nale in his madness, is more rigid than the ancient order, which understood that the law was not perfect, but instead represented an ideal to try to reach over time. Anyone believing in finding true justice, in defending the innocent, and in punishing the guilty would be welcome in the Order.'),
	('Dustbringers', 'Chanaranach', 'The Guard', 'Ruby', 'Ashpren', 'Brave and obedient', '#A43C31', 'Dustbringer oaths were themed toward responsibility. They were led to understand that the powers they used needed to be properly channeled, much as their own desires and wills needed proper form and shape. As a Dustbringer moved through the oaths, they were taught greater powers of destruction—and are one of the only orders where their abilities weren’t all available at the beginning, but instead were delivered slowly, as they made the proper oaths. Each oath led to a greater understanding of power, the nature of holding it, and the associated responsibility.', 'Dustbringers—though they sometimes objected to the common name for their order, preferring instead to be called Releasers—are living contradictions among the Knights Radiant. They believe great power requires a strong will to control it. They often attract tinkerers who like to dig down into the shape and soul of a thing, break it, and see what makes it work. However, their oaths are themed toward control—that they need to be able to control, contain, and channel the terrible power inside them. They tend to object to those who focus only on their destructive sides, as they argue that in order to create, one must understand the pieces of the thing they are trying to make. They don’t see themselves as being about destruction—though their powers are the most destructive of any order of Knights Radiant. They instead see their nature as being about control, precision, and understanding. In the Knights Radiant, they tend to act as the equivalent of artillery in a modern army. If you want a large swath of land destroyed or burned, you call in the Dustbringers. However, they were also often used as sappers, engineers, and strategists. They attract anyone who likes to take things apart, who likes to know how things work. They also attract those who are a little foolhardy at times—brave soldiers who see themselves as containing and controlling terrible destruction so it won’t get out of hand and hurt innocents.'),
        ('Edgedancers', 'Vedeledev', 'Healer', 'Diamond', 'Cultivationspren', 'Loving and healing', '#FBF3EE', 'Edgedancer oaths are themed around remembering the ordinary people of the world—those who aren’t powerful generals or Radiants. Too often, the actions of the powerful have terrible effects on the people with no voice, and the Edgedancers consider it their solemn duty to remember that the people are the ones they truly serve.', 'The Edgedancers are known as being caring and graceful. Among the Knights Radiant, they see it as their duty to care for the people and are often less interested in war than they are about trying to improve the daily lives of the common folk. Often, a mid-sized town would have an Edgedancer or two on permanent assignment, where they’d use Regrowth to provide healing and would work for the common good of the town. Edgedancers tend to be among the more religious of Radiants and are the Order where you’re most likely to find former religious leaders who end up bonding a spren. During wartime, they often act as the mobile medics, eschewing actual combat to heal or pull out the wounded or those trapped in terrible situations. However, there are some renowned for their graceful and skilled prowess in combat, occasionally used as scouts or special forces troops in conjunction with a team of Windrunners or Skybreakers. One should never assume the Edgedancers are in any way base just because they often ignore high society; they are renowned as some of the most refined and graceful of Radiants.'),
	('Truthwatchers', 'Pailiah', 'Scholar', 'Emerald', 'Mistspren', 'Learned and giving', '#294C3A', 'Truthwatcher oaths are themed around seeking to find ultimate truth and sharing it. They are very concerned with knowledge and the proper exploitation of it. Note that this should not be confused with the Lightweavers, whose oaths are themed toward personal truths about themselves, said for reasons of self-actualization. Truthwatchers are more concerned with the fundamental truths of the universe, and whether or not those in power are being truthful with the people they lead.', 'They tend to attract scientists primarily, but also scholars or thinkers of all types. This extends to some who might not normally be known as scholarly but instead as someone often consumed by their own thoughts. In general, they tend to be reserved, particularly in person, though a small minority of Truthwatchers are greatly concerned with the actions of the powerful and might be likened to investigative reporters. These make their opinions known loudly and forcefully, particularly if they think someone in power is abusing that power or lying about fundamental truths. Note that, as with all Knights Radiant, there is great disagreement within the Order about what is the truth. However, Truthwatchers tend to approach these discussions with enthusiasm, even if they generally prefer to write their opinions rather than speak them. Among the Knights Radiant, the Truthwatchers tend to be those who hold the knowledge and secrets of Surgebinding and are the ones to discover many of the newer advances in things like fabrial technology.'),
	('Ligthweavers', 'Shalash', 'Artist', 'Garnet', 'Liespren (Cryptic)', 'Creative and honest', '#64141F', 'Lightweaver oaths are an oddity, perhaps because their spren tend to be the oddest among all Radiant spren. Instead of speaking specific words, or even words along a certain theme, Lightweavers speak truths about themselves—things they must admit to themselves in order to progress as people. It is theorized that because Lightweavers live on the line between reality and fiction, it is important for them to be able to separate the real from the lie, and only with the proper ability to do so can they move forward.', 'Lightweavers are the Radiants most interested in the arts, including all kinds of visual arts and theater. They range widely in personality from the quiet and introspective painter to the outgoing and gregarious stage performer, with everything in between. What unites them tends to be a love of art, though there are some few who are more interested in intrigue, secrets, and espionage. They are the spies of the Knights Radiant and are often untrusted by others (such as the stoic Skybreakers) for their love of subterfuge. They have a reputation for having looser morals than other Orders, but the Lightweavers are quick to point out that their personal values are strong. They just don’t feel they need to match what other more hardline Orders tend to require. They can be vague with oaths, and many say there is far more Cultivation in them than Honor. (Others dispute this, saying that all Orders have an equal mix, despite some spren naming themselves “honorspren.”) Lightweavers tend to be free spirits, and many among their Order see the importance of entertainment, beauty, and art in a person’s life, and strive to make sure that the world doesn’t just live through the Desolations—because mere survival isn’t enough unless there is something to live for.'),
	('Elsecallers', 'Battah', 'Counsellor', 'Zircon', 'Inkspren', 'Wise and careful', '#244E63', 'Elsecaller oaths are, like those of the Lightweavers or Skybreakers, themed toward the individual. In this case, the theme is progress—becoming better with each oath, seeking to explore their true potential and reach it. Because of this, the Order is open to many different types, so long as they want to improve themselves.', 'Thoughtful, careful, and cautious, the Elsecallers are generally regarded as the wisest of the Radiants. They seek self-improvement and personal betterment in their lives, but aren’t limited to one specific theme or set of Ideals. This makes them one of the most open and welcoming of orders, though they do tend to attract those who are less flamboyant. They have their share of scholars, and often a large number of theologians, but also attract those who are interested in leadership. They are good at encouraging others, but some are known to set their sights upon the things they want and then seize them. In the Knights Radiant, they tend to be among the best tacticians, and are logistical geniuses, aided in part by their abilities to create food and water for armies, but also their ability to move in and out of Shadesmar.'),
	('Willshapers', 'Kalak', 'Maker', 'Amethyst', 'Ligthspren (Reachers)', 'Resolute and builder', '#612D5F', 'The Willshapers believe strongly that all people should be free to make their own choices. Their oaths are themed toward freedom and letting people be free to express themselves and make their own way in life.', 'The Willshapers have a reputation for attracting builders, craftspeople, and creators to the Radiants. However, while this aspect of them is accurate, the actual membership of the Order is far more varied. Their powers lend themselves to creation, true, but their oaths are focused on freedom and personal fulfillment. Many among the Willshapers are warriors focused on freeing those who are captive, and others are focused on radical self-expression. The Willshapers contain many gregarious and even flamboyant characters who make their own way, taking the path they choose. They are united through a love of building, but some consider the building of society to be more important than the building of structures. Among the Willshapers, you’ll find both those who dress very conservatively and those who wear very daring and original styles. The common ground is that both agree that freedom to express who you are is the important part. Among the Radiants, they are generally focused on building, training, and making infrastructure. In war, they might be sent to a town to fortify it against an oncoming invasion. Before or in the wake of Desolations, they would teach the people things like sanitation, bronzeworking, or other essentials. Anywhere you find someone resisting tyranny or oppression, you’ll often find a Willshaper cheering them on.'),
	('Stonewards', 'Talenelat', 'Soldier', 'Topaz', 'Peakspren', 'Dependable and resourceful', '#C77047', 'Stoneward oaths focus on team dynamics, on learning to work with others, and on being there for those who need them. They put the interests of others before their own, and will not bend their Ideals for the sake of convenience.', 'Stonewards are the infantry and ground troops of the Radiants and are renowned as their finest soldiers. (A title that, on occasion, the Windrunners dispute.) They tend to attract those who are most interested in warfare, prowess with weapons, or athletics of any sort. They like a challenge, and in times of peace are seen engaging in (and running) various sporting events of both a military and non-military nature. Many enjoy the outdoors, and you’ll find exploration enthusiasts among them, as well as those who just like the fresh air. They tend to be known for their can-do attitudes and for taking on enormous projects (sometimes more than they can handle). However, most agree that the primary attribute of the Stonewards is their dependability. Though sometimes gregarious, they are never flighty. If a Stoneward is your friend, they will be there for you, and that is a core tenet of their Order—to be there when they are needed. Another key attribute is their ability to take a difficult situation with few resources and make something better of it. Though not known as inventors or creators, they are good at improvising solutions to problems in the moment.'),
	('Bondsmiths', 'Ishi', 'Priest', 'Heliodor', 'Stormfather, Nightwatcher and Sibling', 'Pious and guiding', '#E6CB6F', 'Bondsmith oaths are focused on unity, unification, and bringing others together. However, this is a loose theme, as there are so few Bondsmiths—and the three sources of their powers are so different in personality—that the oaths can end up taking a variety of different shapes, depending on the situation.', 'Anyone can become a Bondsmith, subject to persuading one of the three spren who grant Bondsmith powers. Those powers tend to work differently for one Bondsmith than another, and even those Surges they share with other Orders tend to work differently for Bondsmiths. The Bondsmiths are unusual in that there are never more than three full members. Historically, they worked to resolve disputes and help set up functioning governments. Even though there can only be three full members, there were times that some Bondsmiths did take squires. Beyond that, many of the retinues that protected the Bondsmiths were considered members of the Order–going so far as to swear oaths, even though they didn’t have a spren and never would. Some even called this the most pure form of being a Radiant, because these were oaths sworn not in the name of gaining powers, but simply for the good of the oaths themselves. Bondsmiths are generally the heart and soul of the Radiants, the most protected and highly regarded of the Orders, capable of doing incredible things with the nature of oaths, bonds, and power. The Order, including the aforementioned squires and attendants, tends to attract the peacemakers of the world, those who want to bring people together rather than divide them.');

/*
DROP TABLE IF EXISTS radiantOrders_surges;
CREATE TABLE IF NOT EXISTS radiantOrders_surges (
        RadiantOrder_id INT(11) NOT NULL,
        surges_id INT(11) NOT NULL,
        PRIMARY KEY (RadiantOrder_id, surges_id),
        CONSTRAINT fk_radiantOrders_surges
        FOREIGN KEY (RadiantOrder_id)
        REFERENCES radiantOrders(id),
        CONSTRAINT fk_surges_radiantOrders
        FOREIGN KEY (surges_id)
        REFERENCES surges(id)

) ENGINE=InnoDB;

TRUNCATE TABLE radiantOrders_surges;
*/
INSERT INTO radiantOrders_surges (RadiantOrder_id, surges_id) VALUES
        (1, 1),
        (1, 2),
        (2, 2),
        (2, 3),
        (3, 3),
        (3, 4),
        (4, 4),
        (4, 5),
        (5, 5),
        (5, 6),
        (6, 6),
        (6, 7),
        (7, 7),
        (7, 8),
        (8, 8),
        (8, 9),
        (9, 9),
        (9, 10),
        (10, 10),
        (10, 1);

/*
DROP TABLE IF EXISTS missions;
CREATE TABLE IF NOT EXISTS missions (
        id INT(11) NOT NULL AUTO_INCREMENT,
        title VARCHAR(45) NOT NULL,
        description VARCHAR(255),
        location VARCHAR(255),
        severity VARCHAR(45),
        difficulty VARCHAR(45),
        estimatedTime VARCHAR(100),
        active BOOLEAN,
        done BOOLEAN,
        PRIMARY KEY (id)
) ENGINE=InnoDB;

TRUNCATE TABLE missions;
*/
INSERT INTO missions (title, description, location, severity, difficulty, estimatedTime, active, done) VALUES
        ('Eos', 'Itaque et dolorem tempore autem minima rerum itaque iure qui quia consequuntur.', 'Piedralar, Alezkar', 'Mild', 'Very eassy', 'Et qui voluptatem commodi temporibus molestias occaecati earum.', 0, 0),
        ('Ex', 'Reiciendis modi est nihil consectetur commodi dolore et nulla et excepturi fugit eaque et.', 'Palaneo, Kharbranth', 'High', 'Hard', 'Consequatur voluptas ex asperiores et eum a dolor voluptatem et et.', 0, 0),
        ('Laudantium aut', 'Molestiae odit totam ratione deleniti qui voluptatibus libero qui quis et.', 'Urithiru', 'Urgent', 'Very hard', 'Officiis reprehenderit voluptate facere saepe nesciunt.', 0, 0),
        ('Distinctio', 'Rerum quia atque impedit molestiae pariatur animi dolorum laboriosam aliquam vel adipisci quia aut.', 'Reshi Isles', 'Moderate', 'Normal', 'Ut magnam eos suscipit voluptatibus est quis qui.', 0, 0),
        ('Quisquam rerum et', 'Laborum dolore architecto possimus accusantium adipisci corrupti et odit sint voluptas minima nihil quisquam nihil totam rerum alias.', 'Bronze Palace, Azimir, Azir', 'High', 'Easy', 'Et fugiat ad ut dolores dolores impedit.', 0, 0);

/*
DROP TABLE IF EXISTS tasks;
CREATE TABLE IF NOT EXISTS tasks (
        id INT(11) NOT NULL AUTO_INCREMENT,
        title VARCHAR(45) NOT NULL,
        description VARCHAR(255),
        progress INT(11),
        mission_id INT NOT NULL,
        CONSTRAINT fk_mission_tasks
        FOREIGN KEY(mission_id)
        REFERENCES missions(id),
        PRIMARY KEY (id)
) ENGINE=InnoDB;

TRUNCATE TABLE tasks;
*/
INSERT INTO tasks (title, description, progress) VALUES
        ('Nobis temporibus', 'Rerum et laborum eveniet non dignissimos tempora a aut sequi ducimus quasi.', 12),
        ('Quia provident', 'Quis similique rerum recusandae est commodi ratione accusantium soluta omnis minima nam.', 5),
        ('Dolorem at', 'Voluptatibus aliquid quia doloribus non dicta consequatur quam voluptatem quia illo beatae aut totam nisi velit tenetur consectetur et.', 55),
        ('Quas at sapiente', 'Nemo placeat sed et adipisci laboriosam reprehenderit iure dolorem quo neque praesentium fugit consequatur est.', 43),
        ('Quo rerum', 'Vitae aut et possimus exercitationem est autem maiores temporibus totam distinctio sint id sapiente tenetur asperiores voluptatem sed.', 97),
        ('Accusantium', 'Exercitationem vitae quia facilis et provident eveniet inventore qui rerum amet explicabo qui accusantium aut sed laboriosam.', 44),
        ('Voluptatem', 'Eum dolores voluptas itaque repellendus minus impedit voluptates velit blanditiis consectetur consequatur pariatur laudantium nihil.', 76),
        ('Et id', 'Consequatur velit et eum eum sint quae suscipit doloremque quia dolorem voluptatum numquam eligendi molestiae.', 73),
        ('Nesciunt', 'Fugit possimus et quidem dolorem tempora dolorum repudiandae et optio.', 49),
        ('Saepe est', 'Et amet maxime voluptatem et magni officiis consequatur qui nesciunt officia ut.', 23),
        ('Quasi et adipisci', '"Quia nam molestiae enim nemo at animi fugit aliquam incidunt quia voluptas labore error non porro quia.', 62),
        ('Itaque labore rem', 'Et sint a aperiam praesentium animi quia eaque veniam earum soluta.', 25),
        ('Iste deleniti', 'Eaque aut repudiandae non voluptatem labore placeat magni animi quis qui minima beatae.', 6),
        ('Magni', 'Voluptas dolores iusto repudiandae ratione similique id ut aspernatur quis rem similique ullam.', 99),
        ('Voluptatibus omnis id', 'Iusto veniam vitae aut ea quia sed eum pariatur earum nihil nobis sit saepe ipsum pariatur animi commodi.', 6),
        ('Aperiam possimus veritatis', 'Aperiam nulla odio nisi praesentium assumenda est consequatur et dignissimos eaque mollitia reiciendis quas reprehenderit quas iusto quas.', 40),
        ('Veniam amet', 'Sunt similique minus assumenda quo explicabo voluptatibus in nihil mollitia iure eligendi.', 29),
        ('Eum', 'Est molestiae praesentium omnis dolores soluta iure rerum dignissimos in temporibus ea minima voluptatem possimus.', 65),
        ('Ipsum quis', 'Praesentium laborum distinctio doloremque enim nostrum delectus magnam voluptatum qui corrupti nostrum animi.', 62),
        ('Unde', 'Atque et quia temporibus sed dicta voluptas qui minus rem est.', 78);



INSERT INTO missions_tasks (Mission_id, tasks_id) VALUES
        (1, 1),
        (1, 2),
        (1, 3),
        (1, 4),
        (2, 5),
        (2, 6),
        (2, 7),
        (2, 8),
        (3, 9),
        (3, 10),
        (3, 11),
        (3, 12),
        (4, 13),
        (4, 14),
        (4, 15),
        (4, 16),
        (5, 17),
        (5, 18),
        (5, 19),
        (5, 20);



INSERT INTO missionrequirements (requirement, requiredAmount, currentAmount) VALUES
        ('Adhesion', 3, 0),
        ('Gravitation', 4, 0),
        ('Division', 5, 0),
        ('Abrasion', 3, 0),
        ('Ilumination', 5, 0),
        ('Progression', 2, 0),
        ('Transformation', 4, 0),
        ('Transportation', 3, 0),
        ('Cohesion', 5, 0),
        ('Tension', 2, 0),
        ('Windrunners', 5, 0),
        ('Skybreakers',4 , 0),
        ('Dustbringers', 6, 0),
        ('Edgedancers', 3, 0),
        ('Truthwatchers', 5, 0),
        ('Ligthweavers', 3, 0),
        ('Elsecallers', 2, 0),
        ('Willshapers', 5, 0),
        ('Stonewards', 3, 0),
        ('Bondsmiths', 1, 0);


INSERT INTO missions_requirements (Mission_id, requirements_id) VALUES
        (1, 1),
        (1, 2),
        (1, 3),
        (1, 4),
        (2, 5),
        (2, 6),
        (2, 7),
        (2, 8),
        (3, 9),
        (3, 10),
        (3, 11),
        (3, 12),
        (4, 13),
        (4, 14),
        (4, 15),
        (4, 16),
        (5, 17),
        (5, 18),
        (5, 19),
        (5, 20);
















/*
DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
                                     id INT(11) NOT NULL AUTO_INCREMENT,
                                     userName VARCHAR(45) NOT NULL,
                                     userPassowrd VARCHAR(255) NOT NULL,
                                     role ENUM('NO_IDEAL', 'FIRST_IDEAL', 'SECOND_IDEAL', 'THIRD_IDEAL', 'FOURTH_IDEAL', 'FIFTH_IDEAL'),
                                     PRIMARY KEY (id)
) ENGINE=InnoDB;

TRUNCATE TABLE users;
*/
INSERT INTO users(email, name, role, userPassword, knightradiant_id) VALUES
	('jezerezeh@gmail.com', 'Jezerezeh', 1,  'jezerezeh', 95),
	('nalan@gmail.com', 'Nalan', 1,  'nalan', 96),
	('chanaranach@gmail.com', 'Chanaranach', 1,  'chanaranach', 97),
	('vedeledev@gmail.com', 'Vedeledev', 1,  'vedeledev', 98),
	('pailiah@gmail.com', 'Pailiah', 1,  'pailiah', 100),
	('shalash@gmail.com', 'Shalash', 1,  'shalash', 101),
	('battah@gmail.com', 'Battah', 1,  'battah', 102),
	('kalak@gmail.com', 'Kalak', 1,  'kalak', 103),
	('talenelat@gmail.com', 'Talenelat', 1,  'talenelat', 104),
	('ishi@gmail.com', 'Ishi', 1,  'ishi', 105)