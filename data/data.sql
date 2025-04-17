

INSERT INTO LOAISANPHAM (MALOAI, TENLOAI, MOTA, ISDELETED)
VALUES 
    (0, N'Tất cả', N'Tất cả sản phẩm trong cửa hàng', 0),
    (1, N'Đồ uống', N'Nước khoáng, nước đóng chai, nước ngọt, nước tăng lực, rượu bia, ....', 0),
    (2, N'Đồ ăn vặt', N'Bánh, kẹo các loại, socola,....', 0),
    (3, N'Đồ ăn chế biến', N'Mì, bánh mì, cơm, ....', 0),
    (4, N'Thực phẩm', N'Trứng, thịt, cá, rau,....', 0),
    (5, N'Đồ dùng khác', N'Kem đánh răng, áo mưa, dù, dầu gội, sữa tắm....', 0);
	
	INSERT INTO NHACUNGCAP (MANCC, TENNCC, DIACHI, SDT, EMAIL, ISDELETED)
VALUES 
    (1, N'PepsiCo', N'Hoa Kỳ', '02838219436', 'recruitment@intl.pepsico.com', 0),
    (2, N'Coca Cola', N'Hoa Kỳ', '02838961000', 'trucle@coca-cola.com', 0),
    (3, N'Chương Dương', N'Việt Nam', '8483836751', 'info@cdbeco.com.vn', 0),
    (4, N'Masan', N'Việt Nam', '02838961001', 'pr@msn.masangroup.com', 0),
    (5, N'Red Bull', N'Thái Lan', '02838961002', 'customerservice@redbullshopus.com', 0),
    (6, N'Carlsberg', N'Đan Mạch', '02838961004', 'trangthanhphuc91@gmail.com', 0),
    (7, N'Lotte', N'Hàn Quốc', '02838931000', 'cs@lotte.vn', 0),
    (8, N'Trident', N'Hoa Kỳ', '02838964000', 'cs@trident.vn', 0),
    (9, N'Perfetti Van Melle SPA', N'Italy', '02538964000', 'cs@perfertti.vn', 0),
    (10, N'Orion Corporation', N'Hàn Quốc', '02838967000', 'cs@orion.vn', 0),
    (11, N'Nestlé', N'Thụy Sĩ', '02868964000', 'cs@nestle.vn', 0),
    (12, N'MiniMart', N'Việt Nam', '0365336991', 'huynhkhaduy@gmail.com', 0),
    (13, N'GreenFeed', N'Việt Nam', '0343336998', 'cs@feddy.com.vn', 0),
    (14, N'We Care', N'Việt Nam', '0399936998', 'cs@wecare.com.vn', 0),
    (15, N'Silkwell', N'Việt Nam', '0399936312', 'cs@silkwell.com.vn', 0),
    (16, N'Unilever', N'Anh và Hà Lan', '0399936302', 'cs@unilever.com.vn', 0),
    (17, N'Gatsby', N'Nhật Bản', '0323936302', 'cs@gatsby.com.vn', 0),
    (18, N'3M', N'Hoa Kỳ', '0323921302', 'cs@3M.com.vn', 0),
    (19, N'Colgate', N'Hoa Kỳ', '0321231302', 'cs@Colgate.com.vn', 0);




-- Chèn dữ liệu vào bảng SANPHAM
INSERT INTO SANPHAM (TENSP,MOTA, SOLUONG, HINHANH, GIATIEN, MALOAI, MANCC, ISDELETED)
VALUES 
    ('Pepsi', 'Từ thương hiệu nước ngọt có gas nổi tiếng toàn cầu...', 30, 'pepsi', 10600, 1, 1, 0),
    ('Sprite', 'Hương vị được ưa chuộng tại hơn 190 quốc gia...', 50, 'sprite', 8800, 1, 2, 0),
    ('Coca', 'Là loại nước ngọt được nhiều người yêu thích...', 100, 'coca', 10500, 1, 2, 0),
    ('Fanta Cam', 'Là sản phẩm nước ngọt có gas của thương hiệu Fanta...', 20, 'Fanta Cam', 8800, 1, 2, 0),
    ('Fanta Việt Quất', 'Là sản phẩm nước ngọt có gas của thương hiệu Fanta...', 30, 'Fanta Viet Quat', 8800, 1, 2, 0),
    ('7 Up', 'Từ thương hiệu nước giải khát 7Up uy tín...', 15, '7up', 11000, 1, 1, 0),
    ('Sá xị', 'Là sản phẩm truyền thống đặc trưng của Chương Dương...', 22, 'Saxi', 8400, 1, 3, 0),
    ('Soda', 'Sản xuất theo dây chuyền công nghệ hiện đại...', 27, 'Soda', 6800, 1, 2, 0),
    ('Vivant', 'Sản phẩm nước uống đóng chai từ thương hiệu Vivant...', 150, 'vivant', 4600, 1, 4, 0),
    ('Aquafina', 'Được lấy từ nguồn nước ngầm đảm bảo...', 200, 'Aquafina', 4300, 1, 1, 0),
    ('Red Bull', 'Với thành phần tự nhiên, mùi vị thơm ngon...', 19, 'redbull', 9300, 1, 5, 0),
    ('Bia Carlsberg', 'Lên men tự nhiên từ nước, đại mạch, ngũ cốc...', 300, 'carlsberg', 24000, 1, 6, 0),
    ('Kẹo Xylitol', 'Kẹo gum không đường giúp loại bỏ thức ăn thừa...', 35, 'Xylitol', 58800, 2, 7, 0),
    ('Kẹo Trident Bạc Hà', 'Kẹo gum hương bạc hà mang đến hơi thở thơm mát...', 73, 'trident bạc hà', 31800, 2, 8, 0),
    ('Kẹo Trident Chanh', 'Kẹo gum hương bạc hà chanh...', 63, 'trident chanh', 29300, 2, 8, 0),
    ('Kẹo Alpenliebe', 'Với hương vị ngọt ngào của sữa và hương caramen...', 45, 'alpenliebe', 12600, 2, 9, 0),
    ('Kẹo Alpenliebe mix 2 vị', 'Hương vị trái cây thơm ngon...', 40, 'alpenliebe 2', 14000, 2, 9, 0),
    ('Kẹo Chupa Chups', 'Kẹo dẻo Chupa Chups với những hình dáng ngộ nghĩnh...', 40, 'chupa chups', 14600, 2, 9, 0),
    ('Bánh que Toppo', 'Là bánh que chất lượng...', 30, 'toppo', 52800, 2, 7, 0),
    ('Bánh gấu Koala', 'Bánh gấu thơm ngon với lớp vỏ ngoài giòn...', 100, 'koala', 17900, 2, 7, 0),
    ('Bánh gạo Orion', 'Bánh gạo giòn giòn thơm ngon...', 150, 'banhgaoorion', 22600, 2, 10, 0),
    ('Hộp ChocoPie 20 cái', 'Bánh socola với lớp socola béo...', 150, 'chocopie', 68000, 2, 10, 0),
    ('Hộp Custas 6 cái', 'Bánh bông lan thơm mềm, xôm xốp...', 50, 'custas', 25000, 2, 10, 0),
    ('Bánh Marine Boy', 'Bánh quy thơm vị tôm nướng...', 50, 'marineboy', 11600, 2, 10, 0),
    ('Bánh xốp Kitkat', 'Bánh xốp phủ socola ngọt, thơm...', 50, 'kitkat', 6600, 2, 11, 0),
    ('Bánh mì ốp la', 'Bánh mì ốp la là món ăn quen thuộc...', 99, 'banhmiopla', 12000, 3, 12, 0),
    ('Mì trộn', 'Mì Trộn thoạt nhìn có vẻ đơn giản nhưng...', 99, 'mitron', 15000, 3, 12, 0),
	 ( 'Mì trộn trứng', ' Mì Trộn thoạt nhìn có vẻ đơn giản nhưng lại mang một hương vị đặc trưng riêng. Một tô Mì Trộn hấp dẫn với giá cả rất phải chăng, thêm một chút giá, một chút hẹ, có thể dùng thêm sa tế cay cũng làm ấm lòng bạn vào bất kì giờ nào trong ngày. Sẽ tuyệt hơn nếu bạn kết hợp dùng Mì Trộn với một phần trứng chiên để làm tăng hương vị món ăn.', 99, 'mitrontrung', 13000,3, 12,0),
       ( 'Mì trộn trứng xúc xích', ' Mì Trộn thoạt nhìn có vẻ đơn giản nhưng lại mang một hương vị đặc trưng riêng. Một tô Mì Trộn hấp dẫn với giá cả rất phải chăng, thêm một chút giá, một chút hẹ, có thể dùng thêm sa tế cay cũng làm ấm lòng bạn vào bất kì giờ nào trong ngày. Sẽ tuyệt hơn nếu bạn kết hợp dùng Mì Trộn với một phần trứng chiên và xúc xích nướng để làm tăng hương vị món ăn.', 99, 'mitrontrungxucxich', 18000, 3, 12,0),
       ( 'Mì trộn indome', ' Nguyên liệu đơn giản, hương vị đậm đà, hấp dẫn, đó chính là lý do mì trộn Indomie nhiều năm liền đứng trong top 10 món mì được ưa chuộng nhất thế giới..', 99, 'mitronindomie', 13000, 3, 12,0),
       ( 'Xúc xích', ' Xúc Xích tại Mini Mart sử dụng nguồn nguyên liệu từ các nhà cung cấp uy tín trong nước và ngoài nước. Xúc Xích với lõi béo mềm bên trong, được bao bọc bên ngoài bởi một lớp bì giòn dai, chắc chắn sẽ là sự lựa chọn hoàn hảo để xoa dịu cơn đói của bạn.', 99, 'xucxichchebien', 15000, 3, 12,0),
       ( 'Bánh bao khoai môn', ' Bánh Bao Ca Dé và Bánh Bao Khoai Môn, có nhân làm từ đậu xanh và khoai môn là hai lựa chọn thơm ngon cho bạn bên cạnh Bánh Bao truyền thống. Bánh Bao tại Circle K luôn nóng hổi để phục vụ bạn bất cứ lúc nào trong ngày.', 99, 'banhbaokhoaimon', 11000, 3, 12,0),
       ( 'Bánh bao ca dé', ' Bánh Bao Ca Dé và Bánh Bao Khoai Môn, có nhân làm từ đậu xanh và khoai môn là hai lựa chọn thơm ngon cho bạn bên cạnh Bánh Bao truyền thống. Bánh Bao tại Circle K luôn nóng hổi để phục vụ bạn bất cứ lúc nào trong ngày.', 99, 'banhbaocade', 11000, 3, 12,0),
       ( 'Bánh bao trứng cút', ' Bánh Bao Trứng Cút có nhân được làm từ thịt heo, củ hành, trứng cút, và nấm. Sản phẩm luôn được giữ nóng trong tủ hâm riêng cho Bánh Bao, luôn được đảm bảo là bánh mới, chất lượng và an toàn để phục vụ bạn bất cứ lúc nào trong ngày.', 99, 'banhbaotrungcut', 16000, 3, 12,0),
       ( 'Dimsum', ' Vỏ bánh mỏng, mịn bao trọn phần nhân thịt đầy đặn bên trong. Đảm bảo giữ trọn hương vị tươi mới và ngon lành của món ăn.', 99, 'dimsum', 20000,3, 12,0),
       ( 'Bánh giò', ' Bánh Giò được làm từ bột gạo tẻ với nhân làm từ thịt nạc kèm mộc nhĩ và hành khô.', 99, 'banhgio', 13000, 3, 12,0),
       ( 'Xôi lá chuối', ' Phần xôi mềm dẻo được bọc trong lớp lá chuối tươi được hấp chín kỹ. Nhân xôi đủ đầy với thịt gà xé dai dai, nấm đông cô lạ miệng cùng trứng muối  và tôm khô mằn mặn. Tất cả hòa quyện, tạo nên hương vị đặc trưng và thơm ngon. Còn gì bằng khi buổi sớm thức dậy được thưởng thức bữa sáng ấm nóng và ngon lành với món ăn truyền thống.', 99, 'xoilachuoi', 20000,3, 12,0),
       ( 'Sườn heo non 300g', 'Sườn non heo của thương hiệu G được đóng gói và bảo quản đạt các tiêu chuẩn về an toàn toàn thực phẩm. Sườn mềm, thịt săn chắc và thơm nên thường dùng để làm sườn xào chua ngọt, sườn ram mặn,...', 99, 'suonnon', 87000, 4, 13,0),
       ( 'Ba rọi heo 300g', 'Ba rọi heo rút sườn G được đóng gói và bảo quản đạt các tiêu chuẩn về an toàn toàn thực phẩm. Tỉ lệ nạc mỡ xen kẻ, thịt nhiều hơn mỡ nên rất hợp để nướng, chiên với sả ớt, kho, luộc,... ', 99, 'baroi', 79000, 4, 13,0),
       ( 'Thăn bò 500g', 'thịt mềm, xen lẫn với những đường gân dai nhẹ, thăn bò nhập khẩu đông lạnh thích hợp để áp chảo, hoặc làm beefsteak, bò nướng,...', 99, 'thanbo', 153000, 4, 13,0),
       ( 'Hộp trứng gà', 'Hộp 10 trứng gà tươi G có thể luộc chín chế biến thành một số món ăn khác như: thịt kho trứng, cơm chiên trứng,...', 99, 'trungga', 32000, 4, 13,0),
       ( 'Hộp trứng vịt', 'Hộp 10 trứng gà tươi G có thể luộc chín chế biến thành một số món ăn khác như: thịt kho trứng, cơm chiên trứng,...', 99, 'trungvit', 39000, 4, 13,0),
       ( 'Cá hồi 300g', 'Cá hồi cắt khúc đông lạnh vẫn giữ được độ tươi ngon, màu sắc bắt mắt, được sơ chế sạch sẽ an toàn', 99, 'cahoi', 39000, 4, 13,0),
       ( 'Nấm kim châm 150g', 'Nấm kim châm Hàn Quốc được nuôi trồng và đóng gói theo những tiêu chuẩn nghiêm ngặt, bảo đảm các tiêu chuẩn xanh - sạch, chất lượng và an toàn với người dùng. Sợi nấm dai, giòn và ngọt, khi nấu chín rất thơm nên thường được lăn bột chiên giòn, nấu súp hoặc để nướng ăn kèm.', 99, 'namkimcham', 14300, 4, 13,0),
       ( 'Ớt hiểm 50g', 'Với vị cay nồng, thơm, kích thích vị giác của người ăn, ớt là một trong những gia vị không thể thiếu trong nấu ăn cũng như mâm cơm của người Việt. Ớt hiểm luôn giữ được độ tươi mỗi ngày, được nuôi trồng theo quy trình nghiêm ngặt, bảo đảm các chỉ tiêu về an toàn và chất lượng.', 99, 'othiem', 2800, 4,13,0),
       ( 'Chanh 500g', 'Chanh túi 500g với từng trái to, tròn và mọng nước, chanh giúp tạo nên vị chua đậm đà cho nhiều món ăn hay nước uống, khiến cho nhiều người thích mê. Chanh có thể làm nước đá chanh giải nhiệt mùa hè, tạo nên vị chua cho các món như canh chua, lẩu chua,....', 99, 'chanh', 15300, 4, 13,0),
       ( 'Dưa leo 500g', 'Dưa leo baby trồng tại Lâm Đồng là một giống dưa mới, được trồng khá nhiều ở nước ta, đây là một loại rau củ rất ngon, gần như là quen thuộc trong tất cả bữa ăn ở mọi gia đình. Dưa leo chứa rất nhiều chất dinh dưỡng và vitamin rất tốt cho cơ thể. Dưa leo còn có thể dụng để làm đẹp cũng rất hiệu quả.', 99, 'dualeo', 17100,4, 13,0),
       ( 'Khăn ướt We Care 30 miếng', ' Là sản phẩm đến từ thương hiệu khăn ướt We Care. Khăn ướt We Care không mùi gói 30 tờ được làm từ vải không dệt cao cấp, mềm mại không xơ. Đây là loại khăn ướt không chứa cồn, không mùi an toàn cho da và thích hợp cho da nhạy cảm..', 79, 'khanuot', 16000, 5, 14,0),
       ( 'Khăn giấy lụa Silkwell 3 lớp 160 tờ', ' Khăn giấy thương hiệu Silkwell sản xuất tại Việt Nam trên dây chuyền công nghệ cao. Khăn giấy lụa Silkwell 3 lớp 160 tờ 100% bột giấy nguyên chất, không chất huỳnh quang, giấy mềm mại, dai, thấm hút tốt, không bở dính, dễ dàng dùng vệ sinh cá nhân, lau chùi', 59, 'khanlua', 15900, 5, 15,0),
       ( 'Dầu gội Clear 631ml', ' Dầu gội Clear thương hiệu Hà Lan, là dầu gội làm sạch gàu số 1 Việt Nam. Dầu gội sạch gàu Clear mát lạnh bạc hà 631ml với công nghệ sạch gàu 3 tác động: loại bỏ gàu, tấn công gàu, ngăn gàu tái phát và Vitamin B3 nuôi dưỡng da dầu khoẻ hơn.', 39, 'daugoiclear', 166000, 5, 16,0),
       ( 'Dầu xã Dove', ' Dầu xả Dove thương hiệu Unilever nổi tiếng sản xuất Nhật Bản. Dầu xả thành phần chiết xuất tự nhiên, dưỡng chất Keratin. Kem xả Dove phục hồi hư tổn 173ml mang lại mái tóc óng ả, vào nếp thẳng mượt, phục hồi hư tổn', 29, 'dauxadove', 47000,5, 16,0),
       ( 'Wax vuốt tóc Gatsby 25g', ' Sản phẩm wax tạo kiểu tóc chất lượng từ thương hiệu Gatsby. Wax vuốt tóc Gatsby Mat & Hard dày bồng cá tính 25g là sản phẩm dạng wax giúp bạn dễ dàng tạo kiểu và giữ nếp tối đa cho mái tóc mà không gây cảm giác nặng nề khó chịu. Cam kết chính hãng và an toàn cho tóc', 29, 'keowax', 26900, 5, 17,0),
       ( 'Gel diệt khuẩn Lifebuoy 50ml', 'Lifebouy là nhãn hiệu sạch khuẩn số 1 thế giới với sản phẩm nước rửa tay. Nước rửa tay diệt khuẩn Lifebuoy Total 10 50ml giúp diệt 99,99% vi khuẩn gây bệnh, cung cấp thêm thành phần dưỡng ẩm cho đôi tay mềm mại hơn. Thiết kế nhỏ gọn dễ dàng mang theo', 69, 'gelxitkhuan', 28000,5, 16,0),
       ( 'Nước rửa tay Lifebuoy 450g', ' Nước rửa tay Lifebuoy an toàn, chất lượng được nhà nhà lựa chọn tin dùng. Nước rửa tay Lifebuoy bạc bảo vệ chai 450g giúp khử khuẩn, bảo vệ da tay khỏi 99,9% vi khuẩn gây hại. Nước rửa tay với hương thơm nhẹ tạo cảm giác tươi mát sảng khoái sau mỗi lần sử dụng.', 29, 'nuocruatay', 78000, 5, 16,0),
       ( 'Khẩu trang 3M KF94 màu trắng', ' Khẩu trang thương hiệu 3M là mẫu khẩu trang được khuyến cáo sử dụng cho người tiêu dùng. Khẩu trang 3M 3 lớp KF94 9013 màu trắng kháng khuẩn, chống bụi, bảo vệ đường hô hấp. Lọc ít nhất 94% phân tử gây hại và bụi mịn 2.5 micromet. Thiết kế vừa vặn với khuôn mặt không có khoảng hở', 120, 'khautrangtrang', 25900,5, 18,0),
       ( 'Khẩu trang 3M KF94 màu đen', ' Khẩu trang thương hiệu 3M là mẫu khẩu trang được khuyến cáo sử dụng cho người tiêu dùng. Khẩu trang 3M 3 lớp KF94 9013 màu trắng kháng khuẩn, chống bụi, bảo vệ đường hô hấp. Lọc ít nhất 94% phân tử gây hại và bụi mịn 2.5 micromet. Thiết kế vừa vặn với khuôn mặt không có khoảng hở', 120, 'khautrangden', 29000, 5, 18,0),
       ( 'Bộ 2 kem đánh răng Colgate MaxFresh bạc hà 350g', ' Colgate là nhãn hiệu của Mỹ chuyên về các sản phẩm vệ sinh răng miệng bao gồm sản phẩm kem đánh răng. Bộ 2 kem đánh răng Colgate MaxFresh hương bạc hà 350g công thức đặc biệt giúp diệt khuẩn hiệu quả, ngừa sâu răng tối đa, cho răng chắc khỏe và hơi thở thơm mát.', 90, 'kemdanhrang', 60000,5, 19,0),
       ( 'Bàn chai đánh răng Colgate 360 Charcoal Spiral ', 'Bàn chải đánh răng xuất xứ thương hiệu Mỹ. Bàn chải đánh răng Colgate có lông chải xoắn, phủ than hoạt tính. Bàn chải Colgate 360 Charcoal Spiral xoắn kép có đầu bàn chải to với 30% diện tích lông chải tăng thêm, giúp chải sạch hiệu quả.', 50, 'banchay', 42000, 5, 19,0),
       ( 'Nước súc miệng Colgate Plax Peppermint Fresh 750ml', 'Nước súc miệng Colgate được sản xuất tại Thái Lan. Nước súc miệng giúp làm sạch khoang miệng hiệu quả, chăm sóc nướu và mang lại hơi thở thơm ngát tự nhiên. Nước súc miệng Colgate Plax Peppermint Fresh 750ml cho khoang miệng sạch sẽ, diệt vi khuẩn gây hôi miệng.', 23, 'nuocsucmieng', 126000, 5, 19,0);






INSERT INTO CHUCVU (MACHUCVU, TENCHUCVU, MOTA, ISDELETED)
VALUES 
(1, N'Nhân viên bán hàng', N'Thực hiện bán hàng, thanh toán, kiểm tra sản phẩm của cửa hàng', 0),
(2, N'Quản lý cửa hàng', N'Thực hiện quản lý cửa hàng, nhân viên', 0);
;

INSERT INTO NHANVIEN (MANV, TENNV, GIOITINH, CMND, NGAYSINH, SODIENTHOAI, EMAIL, DIACHI, NGAYTHAMGIA, MACHUCVU, ISDELETED) 
VALUES
    (1, N'Nguyễn Công Danh', 0, '3120410088', '2002-06-11', '0123456789', 'danhenk@gmail.com', N'Gò Vấp, HCM', '2022-05-16', 1, 0),
    (2, N'Huỳnh Thanh Quý', 0, '3120410413', '2002-04-24', '0123456798', 'quy@gmail.com', N'Quận 8, HCM', '2022-05-16', 1, 0),
    (3, N'Cao Sơn', 0, '3120560051', '2002-10-16', '0123456518', 'soncao@gmail.com', N'Quận 8, HCM', '2022-05-16', 2, 0),
    (4, N'Admin Nguyễn', 0, '3120410591', '2002-08-11', '0123456728', 'admin@gmail.com', N'Quận 8, HCM', '2022-05-16', 2, 0),
    (5, N'Trung Nguyễn Quyền', 0, '3120410125', '2002-11-26', '0123456738', 'quyennek@gmail.com', N'Quận 8, HCM', '2022-05-16', 1, 0);



INSERT INTO TAIKHOAN (SOTK, TENTK, MATKHAU, MANV, SOLANSAI, NGAYTAO, ISDELETED) 
VALUES
    (1, N'congdanh', N'123', 1, 0, '2022-05-16', 0),
    (2, N'thanhquy', N'123', 2, 0, '2022-05-16', 0),
    (3, N'caoson', N'123', 3, 0, '2022-05-16', 0),
    (4, N'admin', N'123', 4, 0, '2022-05-16', 0),
    (5, N'congdanh', N'123', 5, 0, '2022-05-16', 0);






-- Insert khách hàng
INSERT INTO KHACHHANG (TENKH, GIOITINH, SODIENTHOAI, DIACHI, EMAIL, DIEMTHUONG, ISDELETED) 
VALUES 
    ('Phạm Hồng Sơn', 0, '0154399297', 'Nông Cống, Thanh Hóa', 'hongson@gmail.com', 0, 0),
    ('Ngô Liên Phương', 1, '0844598588', 'Kon Tum, Kon Tum', 'lienphuong@gmail.com', 0, 0),
    ('Đỗ Hải Thanh', 1, '0311715027', 'An Dương, Hải Phòng', 'haithanh@gmail.com', 0, 0),
    ('Võ Bạch Yến', 1, '0896971539', 'Dương Kinh, Hải Phòng', 'bachyen@gmail.com', 0, 0),
    ('Hồ Duy Tâm', 0, '0602273372', 'KBang, Gia Lai', 'duytam@gmail.com', 0, 0),
	( 'Lê Cao Minh',0,'0991763662','Bình Thuỷ, Cần Thơ','caominh@gmail.com',0,0),
	( 'Trần Mộng Giác',0,'0136845039','Bắc Bình, Bình Thuận','monggiac@gmail.com',0,0),
	( 'Lý Mạnh Dũng',0,'0879829915','Duy Tiên, Hà Nam','manhdung@gmail.com',0,0),
	( 'Nguyễn Cường Thịnh',0,'0478326352','Yên Lập, Phú Thọ','cuongthinh@gmail.com',0,0),
	( 'Dương Hoài Phương',1,'0617876595','Văn Lãng, Lạng Sơn','hoaiphuong@gmail.com',0,0),
	( 'Nguyễn Đông Dương',0,'0840854691','Bến Cát, Bình Dương','dongduong@gmail.com',0,0),
	( 'Đỗ Kim Phượng',1,'0337596679','Krông Nô, Đắk Nông','kimphuong@gmail.com',0,0),
	( 'Lê Diễm Trang',1,'0828538660','Uông Bí, Quảng Ninh','diemtrang@gmail.com',0,0),
	( 'Phạm Bích Thoa',1,'0441013903','Tam Nông, Đồng Tháp','bichthoa@gmail.com',0,0),
	( 'Hồ Mộng Long',0,'0649772240','Móng Cái, Quảng Ninh','monglong@gmail.com',0,0),
	( 'Vũ Hùng Dũng',0,'0336300478','Mộc Châu, Sơn La','hungdung@gmail.com',0,0),
	( 'Huỳnh Huy Khánh',0,'0576396002','Nha Trang, Khánh Hòa','huykhanh@gmail.com',0,0),
	( 'Đỗ Minh Khiếu',0,'0470107814','Biên Hòa, Đồng Nai','minhkhieu@gmail.com',0,0),
	( 'Đặng Hướng Thiện',0,'0656449090','Ninh Hải, Ninh Thuận','huongthien@gmail.com',0,0),
	( 'Lê Đình Dương',0,'0414402384','Bắc Giang, Bắc Giang','dinhduong@gmail.com',0,0),
	( 'Bùi Nam An',0,'0835310269','Nậm Nhùn, Lai Châu','naman@gmail.com',0,0),
	( 'Ngô Đông Nguyên',0,'01069693451','Quảng Trạch, Quảng Bình','dongnguyen@gmail.com',0,0),
	( 'Đỗ Danh Văn',0,'0612258069','Thuận Thành, Bắc Ninh','danhvan@gmail.com',0,0),
	( 'Nguyễn Hải Nhi',1,'0579869921','Kỳ Sơn, Hoà Bình','hainhi@gmail.com',0,0),
	( 'Vũ Cát Cát',1,'0881318321','Vũng Tàu, Bà Rịa - Vũng Tàu','catcat@gmail.com',0,0),
	( 'Vũ Cẩm Tú',1,'0712468869','Đức Cơ, Gia Lai','camtu@gmail.com',0,0),
	( 'Lê Hữu Tài',0,'0253867053','Hương Thủy, Thừa Thiên Huế','huutai@gmail.com',0,0),
	( 'Đặng Hương Nhi',1,'0703901479','Cần Giờ, Hồ Chí Minh','huongnhi@gmail.com',0,0);


-- Insert voucher
INSERT INTO VOUCHER (MAVOUCHER, MOTA, NGAYBD, NGAYKT, GIATRITOITHIEU, KMTOIDA, PTGIAM, SOLUOTSD, ISDELETED)
VALUES
    ('GIAM25K', 'Giảm 25k cho đơn từ 100k', '2022-05-16', '2022-06-16', 100000, 25000, 100, 5000, 0),
    ('GIAM10PT', 'Giảm 10% tối đa 200k', '2022-05-16', '2022-06-16', 0, 200000, 10, 5000, 0),
    ('GIAM25PT', 'Giảm 25% khi mua đơn tối thiểu 100k, giảm tối đa 100k', '2022-05-16', '2022-06-16', 100000, 100000, 25, 5000, 0),
    ('GIAM50K', 'Giảm 50k khi mua đơn từ 200k', '2022-05-16', '2022-06-16', 200000, 50000, 100, 5000, 0);


-- Insert giảm giá sản phẩm
INSERT INTO GIAMGIASP (NGAYBD, NGAYKT, PTGIAM, MASP, ISDELETED)
VALUES
    ('2022-05-16', '2022-06-16', 15, 1, 0),
    ('2022-05-16', '2022-06-16', 5, 3, 0),
    ('2022-05-16', '2022-06-16', 10, 4, 0),
    ('2022-05-16', '2022-06-16', 20, 7, 0),
    ('2022-05-16', '2022-06-16', 16, 10, 0);


INSERT INTO PHIEUNHAP (NGAYLAP, MANV, ISDELETED)
VALUES 
    ('2022-05-16 17:33:19', 1, 0),
    ('2022-05-17 17:33:19', 2, 0),
    ('2022-05-17 17:35:19', 1, 0),
    ('2022-05-17 17:39:19', 2, 0),
	  (  '2022-05-17 16:12:19', '3', 0),
    (  '2022-05-17 19:22:19', '1', 0),
    (  '2022-05-17 20:22:19', '2', 0),
    (  '2022-05-17 20:23:19', '1', 0),
    (  '2022-05-17 20:25:19', '3', 0),
    (  '2022-05-17 21:30:19', '1', 0),
    (  '2022-05-17 21:35:20', '3', 0),
    (  '2022-05-17 21:50:54', '5', 0),
    (  '2022-05-17 21:59:19', '5', 0);

-- Insert chi tiết phiếu nhập
INSERT INTO CTPHIEUNHAP (MAPHIEU, MASP, SOLUONG)
VALUES 
      ('1', '34', '8'), ('1', '16', '12'), ('1', '12', '12'), ('1', '8', '10'), 
    ('1', '21', '8'), ('1', '6', '24'), ('2', '37', '13'), ('2', '28', '10'), 
    ('2', '42', '10'), ('2', '43', '12'), ('2', '11', '8'), ('3', '36', '10'), 
    ('3', '37', '14'), ('3', '24', '10'), ('3', '58', '12'), ('4', '55', '15'), 
    ('4', '35', '12'), ('5', '47', '5'), ('5', '33', '10'), ('5', '51', '4'), 
    ('6', '7', '8'), ('6', '49', '10'), ('6', '44', '10'), ('6', '40', '12'), 
    ('6', '50', '10');



-- Insert phiếu hủy
INSERT INTO PHIEUHUY (NGAYLAP, MANV, ISDELETED)
VALUES 
    ('2022-05-16 17:54:45', 1, 0),
    ('2022-05-17 18:05:45', 2, 0),
    ('2022-05-17 18:34:49', 3, 0),
    ('2022-05-17 19:28:49', 5, 0),
    (  '2022-05-17 21:55:49', '4', 0),
    (  '2022-05-17 22:16:49', '2', 0),
	(  '2022-05-17 22:16:49', '2', 0);


-- Insert chi tiết phiếu hủy
INSERT INTO CTPHIEUHUY (MAPHIEU, MASP, SOLUONG)
VALUES 
   ('1', '39', '4'), ('1', '26', '5'), ('1', '27', '3'), ('2', '6', '10'), 
    ('2', '36', '5'), ('2', '44', '4'), ('3', '43', '2'), ('3', '41', '3'), 
    ('3', '30', '6'), ('4', '37', '3'), ('1', '34', '10'), ('4', '38', '5'), 
    ('4', '31', '8'), ('5', '46', '10'), ('5', '51', '2'), ('5', '23', '1'), 
    ('6', '33', '3'), ('6', '47', '9'), ('6', '4', '4'), ('6', '54', '1');

