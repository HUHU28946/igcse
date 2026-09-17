package com.example.data.repository

import com.example.data.model.*

object StudyDataProvider {

    // ----------------------------------------------------
    // IGCSE SUBJECTS
    // ----------------------------------------------------
    private val igcseMaths = Subject(
        id = "igcse_maths",
        name = "Mathematics",
        code = "0580 / 0980",
        level = QualificationLevel.IGCSE,
        examBoard = "Cambridge CAIE",
        category = "Mathematics",
        accentColorHex = 0xFF2563EB,
        summary = "Core & Extended mathematics covering Number, Algebra, Geometry, Mensuration, Coordinate Geometry, Trigonometry, Vectors, and Statistics & Probability.",
        currentSyllabusPeriod = "2025–2027 Syllabus",
        keySyllabusUpdates = listOf(
            "CRITICAL: From 2025 onwards, Paper 1 (Core) and Paper 2 (Extended) are strictly NON-CALCULATOR.",
            "Formulas sheet is now provided inside the question paper for all candidates.",
            "Exact trigonometric values for 0°, 30°, 45°, 60°, and 90° must be known without a calculator.",
            "Surds simplification and rationalizing denominators explicitly examined in Extended."
        ),
        paperStructure = listOf(
            PaperInfo("Paper 2 (Extended Non-Calculator)", "2 hours", 100, 50, false, "Short-answer and structured questions covering all Extended objectives."),
            PaperInfo("Paper 4 (Extended Calculator Allowed)", "2 hours", 100, 50, true, "Structured and multi-part problem-solving questions. Scientific calculator required.")
        ),
        chapters = listOf(
            Chapter(
                id = "igcse_maths_c1",
                chapterNumber = 1,
                title = "Number & Surds (Non-Calculator Focus)",
                description = "Standard form, indices, prime factors, bounds, recurring decimals, and surds operations.",
                lessons = listOf(
                    Lesson(
                        id = "math_l1",
                        chapterId = "igcse_maths_c1",
                        title = "Surds & Rationalising Denominators",
                        estimatedReadMinutes = 8,
                        summary = "Master manipulating radical expressions, simplifying √a × √b = √(ab), and eliminating surds from fractions.",
                        keyConcepts = listOf(
                            "Surd rules: √(ab) = √a × √b and √(a/b) = √a / √b",
                            "Simplification: Factor out the largest square number (e.g. √72 = √(36×2) = 6√2)",
                            "Rationalising monomial denominators: Multiply numerator & denominator by √c",
                            "Rationalising binomial denominators: Multiply by the conjugate (a - √b)"
                        ),
                        syllabusReferences = "Syllabus 0580 Topic E1.11 & E1.12",
                        notes = listOf(
                            NoteSection(
                                heading = "Simplifying Square Roots",
                                bullets = listOf(
                                    "Identify square factors: 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144.",
                                    "Break the radicand into products: √50 = √(25 × 2) = 5√2.",
                                    "Combine like surds: 3√5 + 7√5 - 2√5 = 8√5. Unlike surds like √2 and √3 cannot be directly combined."
                                )
                            ),
                            NoteSection(
                                heading = "Conjugate Pairs for Rationalisation",
                                bullets = listOf(
                                    "A fraction with a surd denominator like 6 / (3 - √5) is un-rationalized.",
                                    "Conjugate of (a + √b) is (a - √b). Using the identity (a+b)(a-b) = a² - b² eliminates the square root: (3 + √5)(3 - √5) = 9 - 5 = 4.",
                                    "Multiply both numerator and denominator: 6(3 + √5) / 4 = (18 + 6√5) / 4 = (9 + 3√5)/2."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Product Rule", "√(ab) = √a × √b", "a ≥ 0, b ≥ 0"),
                            FormulaItem("Quotient Rule", "√(a/b) = √a / √b", "b > 0"),
                            FormulaItem("Difference of Squares", "(a + √b)(a - √b) = a² - b", "b is a non-negative rational")
                        ),
                        examinerTips = listOf(
                            "Examiner Pitfall: Never write decimal approximations on Paper 2 non-calculator questions. Answers must remain in exact form a + b√c.",
                            "Do not forget to fully reduce any common integer factors between numerator and denominator after rationalising."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Rationalise the denominator",
                                question = "Simplify and write in the form a + b√3:  (7 + √3) / (2 - √3)",
                                steps = listOf(
                                    "Multiply numerator and denominator by conjugate (2 + √3).",
                                    "Numerator: (7 + √3)(2 + √3) = 14 + 7√3 + 2√3 + 3 = 17 + 9√3.",
                                    "Denominator: (2 - √3)(2 + √3) = 2² - (√3)² = 4 - 3 = 1."
                                ),
                                answer = "17 + 9√3",
                                examinerInsight = "Full 3 marks awarded for expanding both brackets accurately and stating the final simplified binomial form."
                            )
                        )
                    ),
                    Lesson(
                        id = "math_l2",
                        chapterId = "igcse_maths_c1",
                        title = "Upper & Lower Bounds",
                        estimatedReadMinutes = 7,
                        summary = "Determining limits of accuracy, rounding conventions, and calculating maximum and minimum bounds for operations.",
                        keyConcepts = listOf(
                            "Bounds rule: For a value rounded to nearest unit U, bound interval is ± U/2.",
                            "Division bounds: Max(A/B) = Upper(A) / Lower(B), Min(A/B) = Lower(A) / Upper(B).",
                            "Subtraction bounds: Max(A - B) = Upper(A) - Lower(B)."
                        ),
                        syllabusReferences = "Syllabus 0580 Topic E1.9",
                        notes = listOf(
                            NoteSection(
                                heading = "Determining Bounds",
                                bullets = listOf(
                                    "Rounded to nearest 10: ± 5 (e.g. 140 -> [135, 145))",
                                    "Rounded to 1 d.p.: ± 0.05 (e.g. 8.4 -> [8.35, 8.45))",
                                    "Rounded to 2 s.f.: look at the place value of the 2nd significant figure."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Max Division", "Max(X/Y) = UB(X) / LB(Y)", "Y > 0"),
                            FormulaItem("Min Division", "Min(X/Y) = LB(X) / UB(Y)", "Y > 0")
                        ),
                        examinerTips = listOf(
                            "Candidates frequently divide Upper by Upper when finding maximum division. Always remember: to maximize a fraction, maximize the numerator and MINIMIZE the denominator!"
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Speed Calculation Bounds",
                                question = "Distance d = 150m (correct to nearest 10m). Time t = 12s (correct to nearest second). Calculate the upper bound of average speed.",
                                steps = listOf(
                                    "Find bounds for d: rounded to 10m, so ± 5m -> Upper Bound d = 155m.",
                                    "Find bounds for t: rounded to 1s, so ± 0.5s -> Lower Bound t = 11.5s.",
                                    "Upper bound of speed = UB(d) / LB(t) = 155 / 11.5."
                                ),
                                answer = "13.48 m/s (3 s.f.)",
                                examinerInsight = "Take care to use the lower bound for time to achieve maximum speed quotient."
                            )
                        )
                    )
                )
            ),
            Chapter(
                id = "igcse_maths_c2",
                chapterNumber = 2,
                title = "Algebra & Functions",
                description = "Quadratic equations, factorisation, algebraic fractions, simultaneous equations, and function composition.",
                lessons = listOf(
                    Lesson(
                        id = "math_l3",
                        chapterId = "igcse_maths_c2",
                        title = "Quadratic Equations: Factorising & Formula",
                        estimatedReadMinutes = 9,
                        summary = "Solving ax² + bx + c = 0 by factorisation, completing the square, and using the quadratic formula.",
                        keyConcepts = listOf(
                            "Standard form: Must equate to zero ax² + bx + c = 0 before applying formula.",
                            "Completing square: x² + bx = (x + b/2)² - (b/2)².",
                            "Turning point of y = a(x - h)² + k is at (h, k)."
                        ),
                        syllabusReferences = "Syllabus 0580 Topic E2.5",
                        notes = listOf(
                            NoteSection(
                                heading = "Quadratic Formula",
                                bullets = listOf(
                                    "Formula: x = (-b ± √(b² - 4ac)) / (2a)",
                                    "Discriminant Δ = b² - 4ac determines nature of roots: Δ > 0 (two distinct real roots), Δ = 0 (repeated root), Δ < 0 (no real roots).",
                                    "On Paper 4 (calculator), write formula substitution before evaluating to secure method marks."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Quadratic Formula", "x = (-b ± √(b² - 4ac)) / 2a", "ax² + bx + c = 0, a ≠ 0"),
                            FormulaItem("Completed Square", "y = a(x + p)² + q", "Vertex at (-p, q)")
                        ),
                        examinerTips = listOf(
                            "Watch out for negative signs when evaluating b² (e.g. if b = -5, (-5)² = +25, not -25).",
                            "Give non-exact answers to 2 decimal places when instructed."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Completing the Square",
                                question = "Write x² - 8x + 11 in the form (x - a)² - b. Hence state the minimum coordinates.",
                                steps = listOf(
                                    "Halve the x coefficient: -8 / 2 = -4.",
                                    "(x - 4)² = x² - 8x + 16.",
                                    "Adjust constant: (x - 4)² - 16 + 11 = (x - 4)² - 5.",
                                    "Vertex coordinates: (4, -5)."
                                ),
                                answer = "(x - 4)² - 5, Minimum at (4, -5)",
                                examinerInsight = "Ensure the sign inside the bracket is negative and the minimum y-coordinate is -5."
                            )
                        )
                    )
                )
            )
        )
    )

    private val igcsePhysics = Subject(
        id = "igcse_physics",
        name = "Physics",
        code = "0625 / 0972",
        level = QualificationLevel.IGCSE,
        examBoard = "Cambridge CAIE",
        category = "Sciences",
        accentColorHex = 0xFF7C3AED,
        summary = "Motion, Forces, Energy, Thermal physics, Waves, Electricity & Magnetism, Nuclear physics, and Space physics.",
        currentSyllabusPeriod = "2025–2027 Syllabus",
        keySyllabusUpdates = listOf(
            "Space Physics is a mandatory core section (Section 6: Earth, Solar System, Stars, and the Universe).",
            "Redshift, Hubble Constant equation v = H₀ d, and CMBR (Cosmic Microwave Background Radiation) examined in Extended.",
            "Revised definitions: Momentum p = mv, impulse FΔt = Δp strictly emphasized in Paper 4.",
            "Use of standard SI prefixes and significant figures strictly monitored."
        ),
        paperStructure = listOf(
            PaperInfo("Paper 2 (Multiple Choice Extended)", "45 minutes", 40, 30, true, "40 four-choice multiple-choice questions testing core and extended."),
            PaperInfo("Paper 4 (Theory Extended)", "1 hour 15 mins", 80, 50, true, "Short-answer and structured questions testing calculations, descriptions, and graphs."),
            PaperInfo("Paper 6 (Alternative to Practical)", "1 hour", 40, 20, true, "Written paper testing experimental and laboratory skills without wet labs.")
        ),
        chapters = listOf(
            Chapter(
                id = "igcse_phys_c1",
                chapterNumber = 1,
                title = "Motion, Forces & Energy",
                description = "Speed, velocity, acceleration graphs, Newton's Laws, Hooke's Law, pressure, and energy transfers.",
                lessons = listOf(
                    Lesson(
                        id = "phys_l1",
                        chapterId = "igcse_phys_c1",
                        title = "Velocity-Time Graphs & Motion Equations",
                        estimatedReadMinutes = 8,
                        summary = "Extracting speed, acceleration from gradients, and total distance travelled from area under speed-time graphs.",
                        keyConcepts = listOf(
                            "Gradient of distance-time graph = Speed.",
                            "Gradient of speed-time graph = Acceleration.",
                            "Area under speed-time graph = Distance travelled.",
                            "Constant acceleration equations: a = (v - u) / t."
                        ),
                        syllabusReferences = "Syllabus 0625 Topic 1.2",
                        notes = listOf(
                            NoteSection(
                                heading = "Reading Graphs",
                                bullets = listOf(
                                    "Horizontal line on speed-time graph = constant speed (zero acceleration).",
                                    "Sloping straight line = uniform (constant) acceleration.",
                                    "Curving upwards = increasing acceleration.",
                                    "Divide area under graph into triangles (1/2 b h) and rectangles (b h) or trapezia."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Acceleration", "a = (v - u) / t", "v = final velocity, u = initial velocity, t = time"),
                            FormulaItem("Average Speed", "v = d / t", "Total distance / total time"),
                            FormulaItem("Resultant Force", "F = m a", "m = mass in kg, a = acceleration in m/s²")
                        ),
                        examinerTips = listOf(
                            "Do not confuse distance-time graphs with speed-time graphs: a flat line on distance-time means stationary, but on speed-time it means moving at steady speed!",
                            "Always include unit: acceleration is m/s², speed is m/s, distance is m."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Calculating Distance from Graph",
                                question = "A car accelerates uniformly from rest to 24 m/s in 8.0 s, then maintains 24 m/s for 12.0 s. Calculate total distance travelled.",
                                steps = listOf(
                                    "Phase 1 (Triangle): Area = 0.5 × base × height = 0.5 × 8.0 s × 24 m/s = 96 m.",
                                    "Phase 2 (Rectangle): Area = base × height = 12.0 s × 24 m/s = 288 m.",
                                    "Total Distance = 96 m + 288 m = 384 m."
                                ),
                                answer = "384 m",
                                examinerInsight = "Clear working showing the breakdown of geometric shapes earns all method marks."
                            )
                        )
                    ),
                    Lesson(
                        id = "phys_l2",
                        chapterId = "igcse_phys_c1",
                        title = "Space Physics & Redshift",
                        estimatedReadMinutes = 9,
                        summary = "Solar system orbital speeds, lifecycle of stars, redshift, Hubble's law, and the expanding Universe.",
                        keyConcepts = listOf(
                            "Orbital speed v = 2πr / T.",
                            "Lifecycle: Nebula -> Protostar -> Main sequence -> Red Giant -> Planetary Nebula -> White Dwarf (low mass).",
                            "Redshift: Increase in observed wavelength of electromagnetic radiation from distant galaxies.",
                            "Hubble's Law: v = H₀ d, proving galaxies further away move faster."
                        ),
                        syllabusReferences = "Syllabus 0625 Section 6 Space Physics",
                        notes = listOf(
                            NoteSection(
                                heading = "Redshift & Cosmological Expansion",
                                bullets = listOf(
                                    "Light from distant galaxies is shifted towards the red end of the spectrum (longer wavelength).",
                                    "This indicates that distant galaxies are moving away from Earth (recession).",
                                    "The further the galaxy, the greater the redshift, meaning higher speed of recession.",
                                    "CMBR (Cosmic Microwave Background Radiation) is uniform radiation filling all space, remnant of Big Bang."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Orbital Speed", "v = 2πr / T", "r = orbital radius, T = orbital period"),
                            FormulaItem("Hubble's Law", "v = H₀ d", "H₀ ≈ 2.2 × 10⁻¹⁸ s⁻¹")
                        ),
                        examinerTips = listOf(
                            "Examiner Tip: State clearly that the expansion is of SPACE itself, not galaxies simply flying through empty pre-existing space."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Orbital Speed Calculation",
                                question = "The Earth orbits the Sun at average radius 1.5 × 10⁸ km with a period of 365 days. Calculate its orbital speed in km/h.",
                                steps = listOf(
                                    "Calculate orbital circumference: C = 2 × π × 1.5 × 10⁸ = 9.425 × 10⁸ km.",
                                    "Convert time to hours: T = 365 × 24 = 8760 h.",
                                    "Speed v = 9.425 × 10⁸ / 8760 = 107,588 km/h."
                                ),
                                answer = "1.08 × 10⁵ km/h (3 s.f.)",
                                examinerInsight = "Remember to keep intermediate values unrounded to avoid roundoff errors."
                            )
                        )
                    )
                )
            )
        )
    )

    private val igcseChemistry = Subject(
        id = "igcse_chem",
        name = "Chemistry",
        code = "0620 / 0971",
        level = QualificationLevel.IGCSE,
        examBoard = "Cambridge CAIE",
        category = "Sciences",
        accentColorHex = 0xFF059669,
        summary = "Particulate nature of matter, Stoichiometry, Chemical energetics, Acids, Bases & Salts, Redox, Organic chemistry, and Chemical analysis.",
        currentSyllabusPeriod = "2025–2027 Syllabus",
        keySyllabusUpdates = listOf(
            "IUPAC nomenclature strictly applied (e.g. ethanoic acid, propan-1-ol, but-2-ene).",
            "Updated environmental criteria: microplastics, polymer biodegradability, catalytic converters detailed redox steps.",
            "Bond energy calculations using enthalpy cycle diagrams.",
            "Gas volume constant at r.t.p. is taken as 24 dm³/mol (or 24 000 cm³/mol)."
        ),
        paperStructure = listOf(
            PaperInfo("Paper 2 (Multiple Choice Extended)", "45 minutes", 40, 30, true, "40 multiple-choice questions covering all core and extended topics."),
            PaperInfo("Paper 4 (Theory Extended)", "1 hour 15 mins", 80, 50, true, "Structured theory questions including balancing equations, definitions, and mechanisms."),
            PaperInfo("Paper 6 (Alternative to Practical)", "1 hour", 40, 20, true, "Experimental planning, salt analysis tests, graphs, and error evaluations.")
        ),
        chapters = listOf(
            Chapter(
                id = "igcse_chem_c1",
                chapterNumber = 1,
                title = "Stoichiometry & The Mole Concept",
                description = "Relative formula mass, percentage composition, reacting masses, empirical formula, and molar gas volumes.",
                lessons = listOf(
                    Lesson(
                        id = "chem_l1",
                        chapterId = "igcse_chem_c1",
                        title = "Mole Calculations & Reacting Masses",
                        estimatedReadMinutes = 8,
                        summary = "Mastering n = m / M, concentration C = n / V, and stoichiometric molar ratio conversions.",
                        keyConcepts = listOf(
                            "Number of moles n = mass (g) / Molar mass M (g/mol).",
                            "Concentration c (mol/dm³) = moles n / volume V (dm³). Note: 1 dm³ = 1000 cm³.",
                            "Gas volume V = moles n × 24 dm³ (at r.t.p.).",
                            "Limiting reactant: The reactant completely consumed that limits product formed."
                        ),
                        syllabusReferences = "Syllabus 0620 Topic 3 Stoichiometry",
                        notes = listOf(
                            NoteSection(
                                heading = "3-Step Stoichiometry Method",
                                bullets = listOf(
                                    "Step 1: Calculate moles of the known substance (n = mass / Mr).",
                                    "Step 2: Use the balanced chemical equation to find mole ratio (e.g. 2 : 1).",
                                    "Step 3: Convert moles of unknown into target mass, volume, or concentration."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Moles from Mass", "n = m / M_r", "m in grams, M_r in g/mol"),
                            FormulaItem("Solution Concentration", "c = n / V", "c in mol/dm³, V in dm³"),
                            FormulaItem("Gas Volume at rtp", "V = n × 24 dm³", "1 mole of any gas occupies 24 dm³ at rtp")
                        ),
                        examinerTips = listOf(
                            "Always convert cm³ to dm³ by dividing by 1000 before computing concentration!",
                            "Never round intermediate steps. Keep 4 significant figures in working, give final answer to 3 sig figs."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Mass of Precipitate Calculation",
                                question = "Calculate the mass of calcium carbonate formed when 50.0 cm³ of 0.200 mol/dm³ CaCl₂ reacts with excess Na₂CO₃. [Mr CaCO₃ = 100.1]",
                                steps = listOf(
                                    "Convert volume: V = 50.0 / 1000 = 0.0500 dm³.",
                                    "Calculate moles of CaCl₂: n = c × V = 0.200 × 0.0500 = 0.0100 mol.",
                                    "Equation ratio: CaCl₂ + Na₂CO₃ -> CaCO₃ + 2NaCl (1 : 1 ratio). Moles CaCO₃ = 0.0100 mol.",
                                    "Calculate mass: m = n × Mr = 0.0100 × 100.1 = 1.001 g."
                                ),
                                answer = "1.00 g (3 s.f.)",
                                examinerInsight = "Checking the stoichiometric ratio 1:1 and converting cm³ to dm³ correctly scores maximum marks."
                            )
                        )
                    )
                )
            )
        )
    )

    private val igcseComputerScience = Subject(
        id = "igcse_cs",
        name = "Computer Science",
        code = "0478 / 0984",
        level = QualificationLevel.IGCSE,
        examBoard = "Cambridge CAIE",
        category = "Computing",
        accentColorHex = 0xFF0284C7,
        summary = "Data representation, Data transmission, Hardware, Software, The internet, Automated systems, Algorithm design, and Problem-solving.",
        currentSyllabusPeriod = "2025–2027 Syllabus",
        keySyllabusUpdates = listOf(
            "New section on Artificial Intelligence, robotics, and automated systems in Paper 1.",
            "Standardised Cambridge Pseudocode syntax (DECLARE, FOR ... TO ... NEXT, WHILE ... ENDWHILE, CASE OF).",
            "Logic gates include XOR, NAND, NOR along with truth tables up to 3 inputs.",
            "Two's complement binary representation of negative integers strictly tested."
        ),
        paperStructure = listOf(
            PaperInfo("Paper 1 (Computer Systems)", "1 hour 45 mins", 75, 50, false, "Theory of computer architecture, data representation, networking, and security."),
            PaperInfo("Paper 2 (Algorithms, Programming & Logic)", "1 hour 45 mins", 75, 50, false, "Problem-solving, pseudocode algorithms, arrays, databases, and logic gates.")
        ),
        chapters = listOf(
            Chapter(
                id = "igcse_cs_c1",
                chapterNumber = 1,
                title = "Data Representation & Number Systems",
                description = "Binary, Denary, Hexadecimal conversions, Two's complement, ASCII/Unicode, images, and audio sampling.",
                lessons = listOf(
                    Lesson(
                        id = "cs_l1",
                        chapterId = "igcse_cs_c1",
                        title = "Two's Complement & Hexadecimal Representation",
                        estimatedReadMinutes = 8,
                        summary = "Converting between number bases and representing negative numbers using 8-bit Two's Complement.",
                        keyConcepts = listOf(
                            "Hexadecimal uses base 16 (0-9 and A-F, where A=10, B=11, C=12, D=13, E=14, F=15).",
                            "One hex digit represents 4 bits (a nibble). Two hex digits represent one byte.",
                            "Two's Complement: The Most Significant Bit (MSB) has negative weight (-128 in an 8-bit byte).",
                            "To negate a binary number: Invert all bits (0->1, 1->0) and add 1."
                        ),
                        syllabusReferences = "Syllabus 0478 Topic 1.1",
                        notes = listOf(
                            NoteSection(
                                heading = "Two's Complement Method",
                                bullets = listOf(
                                    "Place values for 8 bits: -128, 64, 32, 16, 8, 4, 2, 1.",
                                    "Example: To represent -42:",
                                    "1. Write +42 in binary: 00101010",
                                    "2. Invert bits (One's complement): 11010101",
                                    "3. Add 1: 11010110",
                                    "Check: -128 + 64 + 16 + 4 + 2 = -42. Verified!"
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("8-Bit Range", "-128 to +127", "2⁸ = 256 unique values"),
                            FormulaItem("Hex Conversion", "Group into 4-bit nibbles", "e.g. 1011 0101 -> B 5")
                        ),
                        examinerTips = listOf(
                            "State WHY hexadecimal is used in computer science: It is easier for humans to read and remember, and reduces errors when transcribing binary strings. It does NOT take less memory in computer storage!",
                            "In Two's complement, if the MSB is 0, the number is positive; if 1, the number is negative."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Binary to Hexadecimal Conversion",
                                question = "Convert 11101001 into hexadecimal notation.",
                                steps = listOf(
                                    "Split into two 4-bit nibbles: 1110 and 1001.",
                                    "Convert left nibble: 8 + 4 + 2 + 0 = 14 -> in Hex that is 'E'.",
                                    "Convert right nibble: 8 + 0 + 0 + 1 = 9 -> in Hex that is '9'.",
                                    "Combine: E9."
                                ),
                                answer = "E9 (or 0xE9)",
                                examinerInsight = "Straightforward 2-mark question. Remember A=10, B=11, C=12, D=13, E=14, F=15."
                            )
                        )
                    )
                )
            )
        )
    )

    // ----------------------------------------------------
    // AS LEVEL SUBJECTS
    // ----------------------------------------------------
    private val asMaths = Subject(
        id = "as_maths",
        name = "Mathematics (AS Level)",
        code = "9709 (P1 & P4 / P5)",
        level = QualificationLevel.AS_LEVEL,
        examBoard = "Cambridge CAIE",
        category = "Mathematics",
        accentColorHex = 0xFFD97706,
        summary = "Pure Mathematics 1 (Quadratics, Coordinate Geometry, Trigonometry, Series, Calculus) and Probability & Statistics 1 or Mechanics.",
        currentSyllabusPeriod = "2025–2027 Syllabus",
        keySyllabusUpdates = listOf(
            "Paper 1 duration is 1 hour 50 minutes (75 marks).",
            "Formula booklet MF19 provided in exam.",
            "Radian measure problems require exact π answers unless decimals explicitly requested.",
            "Chain rule, product rule, quotient rule differentiation tested thoroughly."
        ),
        paperStructure = listOf(
            PaperInfo("Paper 1 (Pure Mathematics 1)", "1 hour 50 mins", 75, 60, true, "Core pure mathematics: quadratics, circles, trigonometry, series, derivatives, integrals."),
            PaperInfo("Paper 5 (Probability & Statistics 1)", "1 hour 15 mins", 50, 40, true, "Permutations, combinations, discrete random variables, normal distribution.")
        ),
        chapters = listOf(
            Chapter(
                id = "as_maths_c1",
                chapterNumber = 1,
                title = "Pure Maths: Differentiation & Integration",
                description = "Derivatives of xⁿ, gradients of tangents and normals, stationary points, definite integrals, and area under curves.",
                lessons = listOf(
                    Lesson(
                        id = "as_math_l1",
                        chapterId = "as_maths_c1",
                        title = "Stationary Points & Nature Determination",
                        estimatedReadMinutes = 10,
                        summary = "Finding dy/dx = 0, calculating stationary coordinates, and using the second derivative test d²y/dx².",
                        keyConcepts = listOf(
                            "Stationary points occur where dy/dx = 0.",
                            "Nature test: If d²y/dx² > 0 -> Local Minimum.",
                            "Nature test: If d²y/dx² < 0 -> Local Maximum.",
                            "If d²y/dx² = 0, test gradient signs either side (point of inflection or minimum/maximum)."
                        ),
                        syllabusReferences = "Syllabus 9709 P1 Topic 7",
                        notes = listOf(
                            NoteSection(
                                heading = "Tangents and Normals",
                                bullets = listOf(
                                    "Gradient of tangent m_t = dy/dx evaluated at x = x₁.",
                                    "Equation of tangent: y - y₁ = m_t(x - x₁).",
                                    "Gradient of normal m_n = -1 / m_t (perpendicular lines).",
                                    "Equation of normal: y - y₁ = m_n(x - x₁)."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Power Rule Derivative", "d/dx (a xⁿ) = a n xⁿ⁻¹", "n is any real constant"),
                            FormulaItem("Second Derivative", "d²y/dx² = d/dx(dy/dx)", "Rate of change of gradient"),
                            FormulaItem("Perpendicular Gradients", "m₁ × m₂ = -1", "For perpendicular lines")
                        ),
                        examinerTips = listOf(
                            "Always find BOTH x and y coordinates when the question asks for 'stationary points'. Finding only x will lose the final accuracy mark.",
                            "State the reason clearly when concluding nature: 'Since d²y/dx² = -6 < 0, the point is a local maximum'."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Finding and Classifying Stationary Points",
                                question = "Curve has equation y = 2x³ - 9x² + 12x + 5. Find the stationary points and determine their nature.",
                                steps = listOf(
                                    "Differentiate: dy/dx = 6x² - 18x + 12.",
                                    "Set to zero: 6(x² - 3x + 2) = 0 -> 6(x - 1)(x - 2) = 0. Roots x = 1 and x = 2.",
                                    "Calculate y values: for x=1: y = 2(1) - 9(1) + 12(1) + 5 = 10. Point (1, 10).",
                                    "For x=2: y = 2(8) - 9(4) + 12(2) + 5 = 16 - 36 + 24 + 5 = 9. Point (2, 9).",
                                    "Second derivative: d²y/dx² = 12x - 18.",
                                    "At x = 1: d²y/dx² = 12(1) - 18 = -6 < 0 -> (1, 10) is a MAXIMUM.",
                                    "At x = 2: d²y/dx² = 12(2) - 18 = +6 > 0 -> (2, 9) is a MINIMUM."
                                ),
                                answer = "(1, 10) is a Maximum; (2, 9) is a Minimum",
                                examinerInsight = "All 5 marks scored: 1 mark for dy/dx, 1 mark for equating to 0, 1 mark for correct coordinates, 2 marks for classification with second derivative."
                            )
                        )
                    )
                )
            )
        )
    )

    private val asPhysics = Subject(
        id = "as_physics",
        name = "Physics (AS Level)",
        code = "9702 (P1, P2 & P3)",
        level = QualificationLevel.AS_LEVEL,
        examBoard = "Cambridge CAIE",
        category = "Sciences",
        accentColorHex = 0xFF4F46E5,
        summary = "Physical Quantities & Units, Kinematics, Dynamics, Forces, Work, Energy & Power, Deformation of Solids, Waves, Superposition, Electricity & Particle Physics.",
        currentSyllabusPeriod = "2025–2027 Syllabus",
        keySyllabusUpdates = listOf(
            "Particle physics section includes quarks, leptons, hadrons, and fundamental interactions.",
            "Young Modulus stress-strain hysteresis and strain energy density formulas evaluated.",
            "Doppler effect equation for sound waves: f_o = f_s v / (v ± v_s) tested in Paper 2.",
            "Strict penalties for inconsistent significant figures with raw experimental data."
        ),
        paperStructure = listOf(
            PaperInfo("Paper 1 (Multiple Choice)", "1 hour 15 mins", 40, 31, true, "40 AS structured multiple-choice questions."),
            PaperInfo("Paper 2 (AS Structured Questions)", "1 hour 15 mins", 60, 46, true, "Calculations, vector diagrams, wave interference, and derivations."),
            PaperInfo("Paper 3 (Advanced Practical Skills)", "2 hours", 40, 23, true, "Laboratory practical exam involving oscilloscopes, optics, circuits, and uncertainties.")
        ),
        chapters = listOf(
            Chapter(
                id = "as_phys_c1",
                chapterNumber = 1,
                title = "Waves & Superposition",
                description = "Progressive waves, transverse and longitudinal, polarization, Doppler effect, diffraction gratings, and stationary waves.",
                lessons = listOf(
                    Lesson(
                        id = "as_phys_l1",
                        chapterId = "as_phys_c1",
                        title = "Double-Slit Interference & Diffraction Gratings",
                        estimatedReadMinutes = 9,
                        summary = "Young's double slit equation λ = ax/D and diffraction grating formula d sin θ = nλ.",
                        keyConcepts = listOf(
                            "Coherence: Constant phase difference between two wave sources.",
                            "Path difference for constructive interference: Δx = nλ.",
                            "Path difference for destructive interference: Δx = (n + 1/2)λ.",
                            "Diffraction grating formula: d sin(θ) = nλ, where d = 1 / (lines per metre)."
                        ),
                        syllabusReferences = "Syllabus 9702 Topic 8 Superposition",
                        notes = listOf(
                            NoteSection(
                                heading = "Young's Double Slit Formula",
                                bullets = listOf(
                                    "Formula: λ = (a x) / D",
                                    "a = slit separation (distance between centers of the two slits, typically in mm or μm).",
                                    "x = fringe separation (distance between centers of adjacent bright fringes).",
                                    "D = distance from slits to screen (typically in metres)."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Double Slit", "λ = (a x) / D", "a = slit spacing, x = fringe width, D = distance to screen"),
                            FormulaItem("Diffraction Grating", "d sin θ = n λ", "d = grating spacing, n = order of maxima")
                        ),
                        examinerTips = listOf(
                            "Watch unit conversions! Slit separation 'a' is often given in mm (×10⁻³ m) or micrometers (×10⁻⁶ m). Convert everything into metres before computing.",
                            "Remember maximum order occurs when sin θ ≤ 1, so n_max = d / λ (rounded DOWN to nearest integer)."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Calculating Wavelength using Double Slits",
                                question = "Slits separated by 0.40 mm are illuminated by monochromatic light. On a screen 2.5 m away, the distance between 10 bright fringes is 37.5 mm. Find wavelength λ.",
                                steps = listOf(
                                    "Distance across 10 fringes represents 9 fringe spacings (x): x = 37.5 mm / 9 = 4.167 × 10⁻³ m.",
                                    "Convert slit separation: a = 0.40 mm = 0.40 × 10⁻³ m.",
                                    "Distance to screen: D = 2.5 m.",
                                    "Use formula: λ = (a × x) / D = (0.40 × 10⁻³ × 4.167 × 10⁻³) / 2.5 = 6.67 × 10⁻⁷ m."
                                ),
                                answer = "6.67 × 10⁻⁷ m (667 nm)",
                                examinerInsight = "Crucial pitfall: 10 fringes have 9 intervals between them! Candidates who divide by 10 lose accuracy marks."
                            )
                        )
                    )
                )
            )
        )
    )

    // ----------------------------------------------------
    // A LEVEL (A2) SUBJECTS
    // ----------------------------------------------------
    private val aLevelMaths = Subject(
        id = "alevel_maths",
        name = "Mathematics (Full A Level / A2)",
        code = "9709 (P3 & P5/P6)",
        level = QualificationLevel.A_LEVEL,
        examBoard = "Cambridge CAIE",
        category = "Mathematics",
        accentColorHex = 0xFFDC2626,
        summary = "Pure Mathematics 3 (Advanced Calculus, Complex Numbers, Differential Equations, Vectors in 3D, Partial Fractions) and Probability & Statistics 2 or Mechanics 2.",
        currentSyllabusPeriod = "2025–2027 Syllabus",
        keySyllabusUpdates = listOf(
            "Pure Mathematics 3 duration: 1 hour 50 mins (75 marks).",
            "Complex numbers: De Moivre's theorem and loci in the Argand diagram |z - z₁| = r and arg(z - z₁) = θ.",
            "Differential equations: Separation of variables with initial conditions and continuous growth/decay models.",
            "Integration by parts and integration using partial fractions explicitly evaluated."
        ),
        paperStructure = listOf(
            PaperInfo("Paper 3 (Pure Mathematics 3)", "1 hour 50 mins", 75, 30, true, "Algebra, logarithmic & exponential functions, trigonometry, integration, differential equations, vectors, complex numbers."),
            PaperInfo("Paper 6 (Probability & Statistics 2)", "1 hour 15 mins", 50, 20, true, "Poisson distribution, continuous random variables, sampling, hypothesis testing.")
        ),
        chapters = listOf(
            Chapter(
                id = "alevel_maths_c1",
                chapterNumber = 1,
                title = "Differential Equations & Advanced Integration",
                description = "Separation of variables, integration by parts, partial fractions, and differential modeling.",
                lessons = listOf(
                    Lesson(
                        id = "alevel_math_l1",
                        chapterId = "alevel_maths_c1",
                        title = "First Order Differential Equations (Separation of Variables)",
                        estimatedReadMinutes = 11,
                        summary = "Solving dy/dx = f(x)g(y) by rearranging all y terms to dy and x terms to dx, integrating both sides, and evaluating the constant of integration.",
                        keyConcepts = listOf(
                            "Separate: ∫ (1 / g(y)) dy = ∫ f(x) dx.",
                            "Integrate both sides and add constant + C to the x side.",
                            "Use boundary conditions (e.g. y=y₀ when x=x₀) to find specific value of C.",
                            "Rearrange into explicit function y = f(x) if requested."
                        ),
                        syllabusReferences = "Syllabus 9709 P3 Topic 8",
                        notes = listOf(
                            NoteSection(
                                heading = "Standard Integration Forms in Differential Equations",
                                bullets = listOf(
                                    "∫ (1 / y) dy = ln|y|",
                                    "∫ (f'(x) / f(x)) dx = ln|f(x)|",
                                    "∫ eᵏˣ dx = (1/k) eᵏˣ",
                                    "Combine constants into ln(A) when dealing with logarithms: ln|y| = kx + ln(A) -> y = A eᵏˣ."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Separation of Variables", "∫ (1/g(y)) dy = ∫ f(x) dx", "When dy/dx = f(x) g(y)"),
                            FormulaItem("Integration by Parts", "∫ u (dv/dx) dx = u v - ∫ v (du/dx) dx", "Choose u using LATE rule (Log, Alg, Trig, Exp)")
                        ),
                        examinerTips = listOf(
                            "Do not omit the constant of integration + C! Omitting C immediately costs up to 3 marks out of 6 in CAIE mark schemes.",
                            "Find C BEFORE attempting complex algebraic rearrangement to make y the subject."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Solving a Population Differential Equation",
                                question = "Solve the differential equation dy/dx = (2x + 1) / y, given that y = 4 when x = 1. Express y in terms of x.",
                                steps = listOf(
                                    "Separate variables: y dy = (2x + 1) dx.",
                                    "Integrate both sides: ∫ y dy = ∫ (2x + 1) dx.",
                                    "y² / 2 = x² + x + C.",
                                    "Apply boundary conditions x = 1, y = 4: 4² / 2 = 1² + 1 + C -> 8 = 2 + C -> C = 6.",
                                    "Substitute C back: y² / 2 = x² + x + 6 -> y² = 2x² + 2x + 12.",
                                    "Take square root (since y=4 > 0, take positive root): y = √(2x² + 2x + 12)."
                                ),
                                answer = "y = √(2x² + 2x + 12)",
                                examinerInsight = "Full 5 marks. Note the explicit positive square root selection since y=4 when x=1."
                            )
                        )
                    )
                )
            )
        )
    )

    private val aLevelPhysics = Subject(
        id = "alevel_phys",
        name = "Physics (Full A Level / A2)",
        code = "9702 (P4 & P5)",
        level = QualificationLevel.A_LEVEL,
        examBoard = "Cambridge CAIE",
        category = "Sciences",
        accentColorHex = 0xFF9333EA,
        summary = "Circular Motion, Gravitational Fields, Temperature & Ideal Gases, Thermodynamics, Oscillations, Electric Fields, Capacitance, Magnetic Fields, Alternating Currents, Quantum Physics, Nuclear Physics, Medical Physics, and Astronomy.",
        currentSyllabusPeriod = "2025–2027 Syllabus",
        keySyllabusUpdates = listOf(
            "Paper 4 is 2 hours (100 marks) accounting for 38.5% of overall A Level mark.",
            "Astronomy and Cosmology is now integrated into A2 Paper 4 (luminosity, Planck radiation, Stefan-Boltzmann law, Hubble's law).",
            "Medical physics imaging techniques (X-ray attenuation, ultrasound acoustic impedance Z = ρc, PET scans) tested with detailed equations.",
            "Paper 5 (Planning, Analysis and Evaluation) strictly tests log linearization (ln y = ln a + b ln x or lg y = lg a + b x)."
        ),
        paperStructure = listOf(
            PaperInfo("Paper 4 (A Level Structured Questions)", "2 hours", 100, 38, true, "Structured theory covering advanced physics topics with extended problem solving."),
            PaperInfo("Paper 5 (Planning, Analysis and Evaluation)", "1 hour 15 mins", 30, 12, true, "Question 1: Experimental design plan. Question 2: Data analysis, error bars, worst-fit lines, uncertainties.")
        ),
        chapters = listOf(
            Chapter(
                id = "alevel_phys_c1",
                chapterNumber = 1,
                title = "Gravitational & Electric Fields",
                description = "Newton's law of gravitation, Coulomb's law, gravitational and electric potential, circular orbits, and field comparisons.",
                lessons = listOf(
                    Lesson(
                        id = "alevel_phys_l1",
                        chapterId = "alevel_phys_c1",
                        title = "Gravitational Potential & Geostationary Orbits",
                        estimatedReadMinutes = 10,
                        summary = "Understanding why gravitational potential is always negative, escape velocity, and calculating geostationary orbit radius.",
                        keyConcepts = listOf(
                            "Gravitational potential Φ at a point is the work done per unit mass in bringing a small test mass from infinity to the point.",
                            "Φ = -GM / r (negative because gravitational force is always attractive, potential is defined as zero at infinity).",
                            "Geostationary satellite: Orbits above the Earth's equator with a period of 24 hours (86400 s), rotating west to east.",
                            "Orbital balance: GMm / r² = m ω² r = m (2π/T)² r."
                        ),
                        syllabusReferences = "Syllabus 9702 Topic 13 Gravitational Fields",
                        notes = listOf(
                            NoteSection(
                                heading = "Geostationary Satellite Properties",
                                bullets = listOf(
                                    "Must be directly above the Earth's equator.",
                                    "Must travel from west to east (same direction as Earth's rotation).",
                                    "Must have an orbital period of exactly 24 hours (1 sidereal day ≈ 8.64 × 10⁴ s).",
                                    "Remains permanently fixed at a single point above the Earth's surface, making it ideal for telecommunications."
                                )
                            )
                        ),
                        formulas = listOf(
                            FormulaItem("Gravitational Potential", "Φ = -GM / r", "G = 6.67 × 10⁻¹¹ N m² kg⁻²"),
                            FormulaItem("Orbital Radius Formula", "r³ = GM T² / (4π²)", "Derived from Newton's Gravitation = Centripetal Force"),
                            FormulaItem("Escape Velocity", "v_esc = √(2GM / r)", "Speed needed to reach infinity with zero kinetic energy")
                        ),
                        examinerTips = listOf(
                            "When defining gravitational potential, NEVER forget to state 'work done PER UNIT MASS' and 'from INFINITY to that point'. Without these keywords, zero marks are awarded.",
                            "Remember that orbital radius r is measured from the CENTRE of the Earth, so r = Radius of Earth + Height above surface."
                        ),
                        workedExamples = listOf(
                            WorkedExample(
                                title = "Calculating Geostationary Orbital Radius",
                                question = "Earth mass M = 5.98 × 10²⁴ kg. Calculate the radius of orbit of a geostationary satellite.",
                                steps = listOf(
                                    "Identify period T = 24 × 3600 = 86,400 s.",
                                    "Equate forces: GMm / r² = m (2π/T)² r -> r³ = GM T² / 4π².",
                                    "Calculate r³ = (6.67 × 10⁻¹¹ × 5.98 × 10²⁴ × 86400²) / (4 × π²).",
                                    "r³ = 7.545 × 10²² m³.",
                                    "Take cube root: r = 4.23 × 10⁷ m (approx 42,300 km from Earth's centre)."
                                ),
                                answer = "4.23 × 10⁷ m (4.23 × 10⁴ km)",
                                examinerInsight = "Take care to cube root accurately and keep period in SI seconds (86,400 s)."
                            )
                        )
                    )
                )
            )
        )
    )

    // Combined list of all available subjects
    val allSubjects: List<Subject> = listOf(
        igcseMaths,
        igcsePhysics,
        igcseChemistry,
        igcseComputerScience,
        asMaths,
        asPhysics,
        aLevelMaths,
        aLevelPhysics
    )

    // ----------------------------------------------------
    // LIVE SYLLABUS CODE UPDATES & EXAM BULLETINS
    // ----------------------------------------------------
    val syllabusUpdates: List<SyllabusCodeUpdate> = listOf(
        SyllabusCodeUpdate(
            id = "upd_0580_calc",
            title = "Cambridge IGCSE 0580: Non-Calculator Paper & Formula Sheet Introduced",
            subjectName = "Mathematics",
            oldCode = "0580",
            currentCode = "0580 / 0980 (9-1)",
            level = QualificationLevel.IGCSE,
            examBoard = "Cambridge CAIE",
            effectiveYears = "2025 – 2027",
            updateType = UpdateCategory.CALCULATOR_POLICY,
            urgency = UpdateUrgency.CRITICAL,
            datePosted = "Updated for 2025/2026 Series",
            overview = "Crucial structural change: Candidates sitting Cambridge IGCSE 0580 can no longer use a calculator on Paper 1 (Core) or Paper 2 (Extended). A standardised formula sheet is now included in the question booklet.",
            detailedChanges = listOf(
                "Paper 1 and Paper 2 are now strictly non-calculator examinations.",
                "Paper 3 and Paper 4 continue to permit scientific calculators.",
                "Candidates must know exact values of sin, cos, and tan for 0°, 30°, 45°, 60°, and 90° without a calculator.",
                "Surds simplification (e.g. rationalising 5 / (2 - √3)) is now directly tested.",
                "Formula sheet provided for all candidates includes volume of sphere (4/3 πr³), cone volume (1/3 πr²h), curved surface area of cone (πrl), and surface area of sphere (4πr²)."
            ),
            examBoardAdvice = "Ensure students practice mental arithmetic, long division, fraction multiplication, and algebraic manipulation without relying on calculators."
        ),
        SyllabusCodeUpdate(
            id = "upd_9618_cs",
            title = "A Level Computer Science: Transition from 9608 to 9618 with Practical Programming",
            subjectName = "Computer Science",
            oldCode = "9608 (Withdrawn)",
            currentCode = "9618",
            level = QualificationLevel.A_LEVEL,
            examBoard = "Cambridge CAIE",
            effectiveYears = "Current & Ongoing",
            updateType = UpdateCategory.SYLLABUS_REVISION,
            urgency = UpdateUrgency.CRITICAL,
            datePosted = "Current Cycle",
            overview = "Syllabus 9608 has been permanently replaced by 9618. Paper 4 is a live on-screen computer programming exam where candidates write, compile, and run code in Python, Java, or Visual Basic.",
            detailedChanges = listOf(
                "Paper 4 requires hands-on coding in a programming IDE on a computer workstation.",
                "Old pseudocode syntax has been harmonized across all papers.",
                "Object-Oriented Programming (Classes, Inheritance, Polymorphism, Encapsulation) tested directly in code.",
                "Data structures tested in Paper 4 include Linked Lists, Binary Trees, Stacks, and Queues."
            ),
            examBoardAdvice = "Candidates must have extensive experience typing and debugging code in Python 3, Java, or VB.NET under timed exam conditions."
        ),
        SyllabusCodeUpdate(
            id = "upd_0625_space",
            title = "IGCSE Physics 0625: Space Physics Section 6 Now Mandatory in All Papers",
            subjectName = "Physics",
            oldCode = "0625",
            currentCode = "0625 / 0972",
            level = QualificationLevel.IGCSE,
            examBoard = "Cambridge CAIE",
            effectiveYears = "2023 – 2026",
            updateType = UpdateCategory.ASSESSMENT_RESTRUCTURE,
            urgency = UpdateUrgency.IMPORTANT,
            datePosted = "Active Syllabus Notice",
            overview = "Space Physics is an established examination topic assessed in Paper 2, Paper 4, and Paper 6.",
            detailedChanges = listOf(
                "Includes orbital motion equations v = 2πr / T.",
                "Lifecycles of low-mass and high-mass stars (protostar, main sequence, red supergiant, supernova, neutron star/black hole).",
                "Cosmology: Redshift of light from distant galaxies, Hubble's Law v = H₀ d, and Cosmic Microwave Background Radiation (CMBR)."
            ),
            examBoardAdvice = "Review past papers from June 2023 onwards to see the format of Space Physics questions."
        ),
        SyllabusCodeUpdate(
            id = "upd_9709_time",
            title = "A Level Mathematics 9709: Paper 1 Pure Mathematics Timing Revised",
            subjectName = "Mathematics",
            oldCode = "9709",
            currentCode = "9709",
            level = QualificationLevel.AS_LEVEL,
            examBoard = "Cambridge CAIE",
            effectiveYears = "2025 – 2027",
            updateType = UpdateCategory.ASSESSMENT_RESTRUCTURE,
            urgency = UpdateUrgency.IMPORTANT,
            datePosted = "Official Cambridge Notice",
            overview = "Pure Mathematics 1 duration is 1 hour 50 minutes for 75 marks. Greater emphasis placed on mathematical modeling and geometric proofs.",
            detailedChanges = listOf(
                "Calculators must not have symbolic algebraic manipulation capabilities (CAS forbidden).",
                "MF19 formula booklet provided.",
                "Students must show full analytical working for calculus questions; calculator numerical integration alone receives zero marks."
            ),
            examBoardAdvice = "Always write intermediate substitution steps before quoting decimal values."
        ),
        SyllabusCodeUpdate(
            id = "upd_timetable_alert",
            title = "Cambridge International Exam Timetable Alert: May/June & Oct/Nov Series",
            subjectName = "All Subjects",
            oldCode = null,
            currentCode = "Administrative Timetable",
            level = QualificationLevel.IGCSE,
            examBoard = "Cambridge CAIE & Edexcel",
            effectiveYears = "2025/2026 Academic Years",
            updateType = UpdateCategory.TIMETABLE_EXAM_ALERT,
            urgency = UpdateUrgency.INFO,
            datePosted = "Annual Release",
            overview = "Key Key Time (KT) regulations and administrative zones (Zone 1 to Zone 6) dictate session start times for exam integrity.",
            detailedChanges = listOf(
                "Candidates must remain under Full Centre Supervision during Key Time.",
                "May/June series written papers typically run from late April through early June.",
                "Oct/Nov series written papers run from early October through mid November.",
                "Results released in mid-August for May/June and mid-January for Oct/Nov."
            ),
            examBoardAdvice = "Check your specific administrative zone (Zone 1 to 6) to verify the precise local Key Time."
        )
    )

    // ----------------------------------------------------
    // PRACTICE EXERCISES & QUIZZES
    // ----------------------------------------------------
    val sampleExercises: List<ExerciseQuestion> = listOf(
        ExerciseQuestion(
            id = "q_math_01",
            subjectId = "igcse_maths",
            subjectCode = "0580",
            level = QualificationLevel.IGCSE,
            topic = "Surds & Radicals (Paper 2 Non-Calculator)",
            questionText = "Simplify the expression (√48 + √27) / √3 without using a calculator.",
            options = listOf("5", "7", "√25", "9"),
            correctIndex = 1,
            explanation = "√48 = √(16 × 3) = 4√3. √27 = √(9 × 3) = 3√3. So the numerator is 4√3 + 3√3 = 7√3. Dividing by √3 gives (7√3) / √3 = 7.",
            marks = 2,
            examinerPitfall = "Do not try to add the numbers under the root: √(48+27) = √75 is mathematically invalid!"
        ),
        ExerciseQuestion(
            id = "q_math_02",
            subjectId = "igcse_maths",
            subjectCode = "0580",
            level = QualificationLevel.IGCSE,
            topic = "Upper & Lower Bounds",
            questionText = "A rectangle has length L = 8 cm and width W = 5 cm, both measured to the nearest centimetre. What is the UPPER BOUND of its perimeter?",
            options = listOf("26 cm", "28 cm", "27 cm", "25 cm"),
            correctIndex = 1,
            explanation = "Since rounded to nearest cm, bound interval is ± 0.5 cm. Upper bound for L = 8.5 cm, Upper bound for W = 5.5 cm. Perimeter = 2(L + W) = 2(8.5 + 5.5) = 2(14) = 28 cm.",
            marks = 2,
            examinerPitfall = "Remember to add 0.5 cm to BOTH length and width before computing the perimeter."
        ),
        ExerciseQuestion(
            id = "q_phys_01",
            subjectId = "igcse_physics",
            subjectCode = "0625",
            level = QualificationLevel.IGCSE,
            topic = "Space Physics & Cosmology",
            questionText = "What phenomenon provides primary evidence that the Universe is expanding?",
            options = listOf(
                "Blue shift of light from Andromeda galaxy",
                "Redshift of light observed from distant galaxies",
                "The gravitational deflection of starlight near the Sun",
                "The continuous fusion of hydrogen in main sequence stars"
            ),
            correctIndex = 1,
            explanation = "Light from distant galaxies shows an increase in wavelength (redshift), indicating that space itself is expanding and galaxies are receding from each other.",
            marks = 1,
            examinerPitfall = "Do not confuse local gravitationally-bound galaxies (like Andromeda which is moving towards the Milky Way) with the general cosmological expansion of distant galaxies."
        ),
        ExerciseQuestion(
            id = "q_asmath_01",
            subjectId = "as_maths",
            subjectCode = "9709",
            level = QualificationLevel.AS_LEVEL,
            topic = "Pure Mathematics: Differentiation",
            questionText = "A curve has equation y = x³ - 3x. What is the value of d²y/dx² at the stationary point where x = 1, and what is its nature?",
            options = listOf(
                "+6, Local Minimum",
                "-6, Local Maximum",
                "0, Point of Inflection",
                "+3, Local Minimum"
            ),
            correctIndex = 0,
            explanation = "dy/dx = 3x² - 3. Stationary at x = 1. d²y/dx² = 6x. At x = 1, d²y/dx² = 6(1) = +6. Because d²y/dx² > 0, the curve is concave up, which signifies a LOCAL MINIMUM.",
            marks = 3,
            examinerPitfall = "Students often mistakenly assume a positive second derivative means maximum. Remember: positive d²y/dx² means gradient is increasing, so it is a MINIMUM!"
        ),
        ExerciseQuestion(
            id = "q_alevel_math_01",
            subjectId = "alevel_maths",
            subjectCode = "9709",
            level = QualificationLevel.A_LEVEL,
            topic = "Pure Mathematics 3: Differential Equations",
            questionText = "If dy/dx = 2y and y = 3 when x = 0, what is y in terms of x?",
            options = listOf(
                "y = 3 e²ˣ",
                "y = e²ˣ + 2",
                "y = 2 e³ˣ",
                "y = 3x² + 3"
            ),
            correctIndex = 0,
            explanation = "Separating variables: (1/y) dy = 2 dx. Integrating: ln|y| = 2x + c. Exponentiating: y = A e²ˣ. Since y = 3 when x = 0: 3 = A e⁰ -> A = 3. Therefore y = 3 e²ˣ.",
            marks = 3,
            examinerPitfall = "Never add the constant outside the exponent as e²ˣ + C; it must be e^(2x + c) = A e²ˣ."
        )
    )

    // ----------------------------------------------------
    // LATEST PAST PAPERS & MARK SCHEMES
    // ----------------------------------------------------
    val samplePastPapers: List<PastPaper> = listOf(
        PastPaper(
            id = "pp_0580_2024_mj_22",
            subjectId = "igcse_maths",
            subjectCode = "0580",
            subjectName = "Mathematics",
            level = QualificationLevel.IGCSE,
            year = "2024",
            series = "May/June",
            paperNumber = "Paper 2 (Extended)",
            paperCode = "0580/22",
            duration = "1 hour 30 mins",
            maxMarks = 70,
            gradeThresholds = GradeThreshold(
                aStar = 58,
                gradeA = 48,
                gradeB = 38,
                gradeC = 29,
                gradeD = 21,
                gradeE = 14
            ),
            sampleQuestions = listOf(
                PaperQuestionPreview(
                    qNumber = "Question 3",
                    questionText = "Factorise completely: 18x² - 50y²",
                    marks = 2,
                    markSchemeSolution = "Step 1: Take out common factor 2 -> 2(9x² - 25y²). Step 2: Difference of squares -> 2(3x - 5y)(3x + 5y). [B2]"
                ),
                PaperQuestionPreview(
                    qNumber = "Question 8",
                    questionText = "Solve the simultaneous equations: 3x - 2y = 19 and 2x + 5y = 0",
                    marks = 3,
                    markSchemeSolution = "Multiply (1) by 5: 15x - 10y = 95. Multiply (2) by 2: 4x + 10y = 0. Add equations: 19x = 95 -> x = 5. Substitute into (2): 2(5) + 5y = 0 -> 5y = -10 -> y = -2. x = 5, y = -2 [M1 A1 A1]"
                )
            ),
            examinerKeyAdvice = listOf(
                "Always check for a common numerical factor before applying the difference of two squares identity.",
                "Candidates frequently lost accuracy marks on simultaneous equations by making arithmetic sign errors when subtracting negative terms."
            )
        ),
        PastPaper(
            id = "pp_0580_2025_specimen",
            subjectId = "igcse_maths",
            subjectCode = "0580",
            subjectName = "Mathematics",
            level = QualificationLevel.IGCSE,
            year = "2025 Specimen",
            series = "New Non-Calculator Format",
            paperNumber = "Paper 2 (Extended Non-Calculator)",
            paperCode = "0580/02 Specimen",
            duration = "2 hours",
            maxMarks = 100,
            gradeThresholds = GradeThreshold(
                aStar = 81,
                gradeA = 68,
                gradeB = 54,
                gradeC = 41,
                gradeD = 30,
                gradeE = 20
            ),
            sampleQuestions = listOf(
                PaperQuestionPreview(
                    qNumber = "Question 1",
                    questionText = "Work out 3/8 ÷ 5/12. Give your answer as a fraction in its simplest form.",
                    marks = 2,
                    markSchemeSolution = "3/8 × 12/5 = 36 / 40 = 9 / 10. [M1 A1]"
                ),
                PaperQuestionPreview(
                    qNumber = "Question 14",
                    questionText = "Find the exact value of sin(60°) × cos(30°) + tan(45°).",
                    marks = 3,
                    markSchemeSolution = "sin(60°) = (√3)/2. cos(30°) = (√3)/2. Product = (√3/2)(√3/2) = 3/4. tan(45°) = 1. Total = 3/4 + 1 = 7/4 (or 1 3/4). [B1 B1 A1]"
                )
            ),
            examinerKeyAdvice = listOf(
                "Candidates must be confident working without calculators under the 2025 syllabus.",
                "Show clear cancellation steps in fractions to ensure method marks are preserved."
            )
        ),
        PastPaper(
            id = "pp_9709_2024_mj_12",
            subjectId = "as_maths",
            subjectCode = "9709",
            subjectName = "Mathematics (AS)",
            level = QualificationLevel.AS_LEVEL,
            year = "2024",
            series = "May/June",
            paperNumber = "Paper 1 (Pure Mathematics 1)",
            paperCode = "9709/12",
            duration = "1 hour 50 mins",
            maxMarks = 75,
            gradeThresholds = GradeThreshold(
                aStar = 65,
                gradeA = 55,
                gradeB = 46,
                gradeC = 37,
                gradeD = 28,
                gradeE = 19
            ),
            sampleQuestions = listOf(
                PaperQuestionPreview(
                    qNumber = "Question 2",
                    questionText = "Find the coefficient of x³ in the binomial expansion of (2 - 3x)⁶.",
                    marks = 3,
                    markSchemeSolution = "General term: ⁶C₃ × (2)³ × (-3x)³ = 20 × 8 × (-27 x³) = -4320 x³. Coefficient is -4320. [M1 M1 A1]"
                )
            ),
            examinerKeyAdvice = listOf(
                "Take care with negative sign (-3x)³ = -27x³. Forgetting the negative sign was the most common error in this series."
            )
        ),
        PastPaper(
            id = "pp_9709_2024_mj_32",
            subjectId = "alevel_maths",
            subjectCode = "9709",
            subjectName = "Mathematics (A Level)",
            level = QualificationLevel.A_LEVEL,
            year = "2024",
            series = "May/June",
            paperNumber = "Paper 3 (Pure Mathematics 3)",
            paperCode = "9709/32",
            duration = "1 hour 50 mins",
            maxMarks = 75,
            gradeThresholds = GradeThreshold(
                aStar = 62,
                gradeA = 53,
                gradeB = 44,
                gradeC = 35,
                gradeD = 26,
                gradeE = 17
            ),
            sampleQuestions = listOf(
                PaperQuestionPreview(
                    qNumber = "Question 5",
                    questionText = "Use the substitution u = cos(x) to show that ∫ (sin(x) / (2 + cos(x))) dx = -ln(2 + cos(x)) + C.",
                    marks = 4,
                    markSchemeSolution = "du = -sin(x) dx, so sin(x) dx = -du. Integral becomes ∫ (-1 / (2 + u)) du = -ln|2 + u| + C = -ln|2 + cos(x)| + C. [M1 M1 A1 A1]"
                )
            ),
            examinerKeyAdvice = listOf(
                "Do not forget modulus or brackets around logarithm arguments, and always include the arbitrary constant + C."
            )
        )
    )
}
